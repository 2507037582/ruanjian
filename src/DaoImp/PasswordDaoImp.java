package DaoImp;

import domain.User;
import utils.DataSourceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PasswordDaoImp {
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	public List<User> getAllPassword(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		String a=(String) session.getAttribute("username");
		ResultSet rs=null;  
		List<User> list;
		try {
			conn = DataSourceUtils.getConnection();
			list = new ArrayList<User>();
			conn= DataSourceUtils.getConnection();
    		pstmt = conn.prepareStatement("select * from user where username=?");
    		pstmt.setString(1, a);
    		rs = pstmt.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<User> getAllEmail(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		String a=(String) session.getAttribute("username");
		ResultSet rs=null;  
		List<User> list;
		try {
			conn = DataSourceUtils.getConnection();
			list = new ArrayList<User>();
			conn= DataSourceUtils.getConnection();
    		pstmt = conn.prepareStatement("select * from user where username=?");
    		pstmt.setString(1, a);
    		rs = pstmt.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
