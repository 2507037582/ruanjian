package DaoImp;

import domain.Orders;
import utils.DataSourceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CostDaoImp{

	private Connection conn= null;
	private PreparedStatement pstmt = null;
	public List<Orders> getAllCost(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		String a=(String) session.getAttribute("username");
		ResultSet rs=null;  
		List<Orders> list;
		try {
			conn = DataSourceUtils.getConnection();
			list = new ArrayList<Orders>();
			conn= DataSourceUtils.getConnection();
    		pstmt = conn.prepareStatement("select * from orders where username=?");
    		pstmt.setString(1, a);
    		rs = pstmt.executeQuery();
			while(rs.next()){
				Orders orders=new Orders();
				orders.setId(rs.getString("id"));
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
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
