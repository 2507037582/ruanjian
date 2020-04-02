package dao;

import domain.Text;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileDao {
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	public int delete(String id) throws SQLException {
		ResultSet rs=null;
		conn= DataSourceUtils.getConnection();
		pstmt = conn.prepareStatement("select filename from file where id=?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		rs.next();
		String filename=rs.getString("filename");
		String path="/usr/java/tomcat/apache-tomcat-8.5.41/webapps/text/"+filename;
		File file=new File(path);
		file.delete();
		if(file.exists()&&file.isFile()&&file.delete()){
			
		}
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from file where id=?";
		int delete=runner.update(sql,id);
		return delete;
	}

	public int insert(Text text) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into file values(?,?)";
		int update=runner.update(sql,null,text.getFilename());
		return update;
	}
}
