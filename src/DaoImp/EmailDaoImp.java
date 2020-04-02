package DaoImp;

import domain.Email;
import utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmailDaoImp {
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	public List<Email> getAllEmail(){
		
		List<Email> list;
		try {
			conn = DataSourceUtils.getConnection();
			
			list = new ArrayList<Email>();
			
			String sql="select * from email";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Email email=new Email();
				email.setId(rs.getInt("id"));
				email.setTime(rs.getTimestamp("time"));
				email.setTitle(rs.getString("title"));
				email.setContent(rs.getString("content"));
				list.add(email);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Email> getFirstEmail(){
		
		List<Email> list;
		try {
			conn = DataSourceUtils.getConnection();
			
			list = new ArrayList<Email>();
			String sql="select * from email order by id desc limit 1";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Email email=new Email();
				email.setTime(rs.getTimestamp("time"));
				email.setTitle(rs.getString("title"));
				email.setContent(rs.getString("content"));
				list.add(email);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
