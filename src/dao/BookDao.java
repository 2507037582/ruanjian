package dao;

import domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDao {
	public int insert( Book book) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		Connection conn = DataSourceUtils.getConnection();
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
		ResultSet rset = stmt.executeQuery("select * from book"); 
		rset.last(); 
		int rowCount = rset.getRow(); //���ResultSet��������  
		rowCount=rowCount+1;
		String sql="insert into book values(?,?,?,?,?,?,?,?,?,?)";
		int update=runner.update(sql,rowCount,book.getCourse_name(),book.getCourse_type(),book.getMajor(),book.getGrade(),book.getTeacher(),book.getBook_name(),book.getAuthor(),book.getTimes(),book.getPublish());
		return update;
	}
	public int delete(String id) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from book where id=?";
		int delete=runner.update(sql,id);
		return delete;
	}
}
