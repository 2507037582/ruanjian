package dao;

import domain.Orders;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CostDao {
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	public int insert(String id,Orders orders) throws SQLException{
		List<Orders> list;
		int update=0;
		try {
			list = new ArrayList<Orders>();
			ResultSet rs=null;
			conn=DataSourceUtils.getConnection();
    		pstmt = conn.prepareStatement("select * from book where id=?");
    		pstmt.setString(1, id);
    		rs = pstmt.executeQuery();
			while(rs.next()){
				orders.setCourse_name(rs.getString("course_name"));
				orders.setCourse_type(rs.getString("course_type"));
				orders.setMajor(rs.getString("major"));
				orders.setGrade(rs.getString("grade"));
				orders.setTeacher(rs.getString("teacher"));
				orders.setBook_name(rs.getString("book_name"));
				orders.setAuthor(rs.getString("author"));
				orders.setTimes(rs.getString("times"));
				orders.setPublish(rs.getString("publish"));
				list.add(orders);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		pstmt = conn.prepareStatement("select * from orders where username=? and course_name=?");
		pstmt.setString(1, orders.getUsername());
		pstmt.setString(2, orders.getCourse_name());
		ResultSet rs=pstmt.executeQuery();
		if(!rs.next()){
		String sql="insert into orders values(?,?,?,?,?,?,?,?,?,?,?,?)";
		update=runner.update(sql,orders.getUsername(),orders.getName(),null,orders.getCourse_name(),orders.getCourse_type(),orders.getMajor(),orders.getGrade(),orders.getTeacher(),orders.getBook_name(),orders.getAuthor(),orders.getTimes(),orders.getPublish());
		}
		return update;
	}
	public int delete(String id) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from orders where id=?";
		int delete=runner.update(sql,id);
		return delete;
	}
}
