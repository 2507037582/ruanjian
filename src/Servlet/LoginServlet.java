package Servlet;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//??????????????
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		//?????????????????????????????
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where username=? and name=? and password=?";
		User user=null;
		try {
			user=runner.query(sql,new BeanHandler<User>(User.class),username,name,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//??????????????bu't??????
		if(user!=null)
		{
			//?????????
			HttpSession session = request.getSession();
			HttpSession session1=request.getSession();
            // 2.?????????????session??
            session.setAttribute("username",username);
            session1.setAttribute("name", name);
            response.sendRedirect(request.getContextPath()+"/emailindex");
		}else{
			 request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}