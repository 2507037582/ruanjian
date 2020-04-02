package dao;

import domain.Email;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UserDao {
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	private PreparedStatement pstmt1 = null;
	public int regist(User user) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into user values(?,?,?,?)";
		int update=runner.update(sql,user.getUsername(),user.getName(),user.getPassword(),user.getEmail());
		return update;
	}

	public Long checkUsername(String username) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from user where username=?";
		Long query=(Long) runner.query(sql, new ScalarHandler(),username);
		return query;
	}

	public Long checkName(String name) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from user where name=?";
		Long query=(Long) runner.query(sql, new ScalarHandler(),name);
		return query;
	}

	public void sendemail(User user, Email email, String id) throws MessagingException {
		// TODO Auto-generated method stub
		// ����Properties �����ڼ�¼�����һЩ����
        Properties props = new Properties();
        // ��ʾSMTP�����ʼ���������������֤
        props.put("mail.smtp.auth", "true");
        //�˴���дSMTP������
        props.put("mail.smtp.host", "smtp.qq.com");
        //�˿ںţ�QQ��������������˿ڣ�������һ����һֱʹ�ò��ˣ����Ծ͸�����һ��587
        props.put("mail.smtp.port", "587");
        // �˴���д����˺�
        props.put("mail.user", "2507037582@qq.com");
        // �˴����������ǰ��˵��16λSTMP����
        props.put("mail.password", "iuedyglemncwdiai");

        // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // �û���������
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
        Session mailSession = Session.getInstance(props, authenticator);
        // �����ʼ���Ϣ
        MimeMessage message = new MimeMessage(mailSession);
        // ���÷�����
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);
        try {
        	String title=null;
        	String content=null;
        conn=DataSourceUtils.getConnection();
        pstmt1 = conn.prepareStatement("select * from email where id=?");
        pstmt1.setString(1,id);
        ResultSet rs=null;
        rs = pstmt1.executeQuery();
        while(rs.next()){
        email.setTitle(rs.getString("title"));
        email.setContent(rs.getString("content"));
        title=email.getTitle();
        content=email.getContent();
        }
		pstmt = conn.prepareStatement("select email from user");
		rs = pstmt.executeQuery();
		while(rs.next()){
			user.setEmail(rs.getString("email"));
			// �����ռ��˵�����
	        InternetAddress to = new InternetAddress(user.getEmail());
	        message.setRecipient(RecipientType.TO, to);
	        // �����ʼ�����
	        message.setSubject(title);
	        // �����ʼ���������
	        message.setContent(content, "text/html;charset=UTF-8");
	        // ���Ȼ���Ƿ����ʼ���
	        Transport.send(message);
		}
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
