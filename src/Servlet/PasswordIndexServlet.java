package Servlet;

import DaoImp.PasswordDaoImp;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class PasswordIndexServlet
 */
public class PasswordIndexServlet extends HttpServlet {
	PasswordDaoImp passwordDaoImp=new PasswordDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<User> list =passwordDaoImp.getAllPassword(request);
		request.setAttribute("passwordList", list);
		List<User> list1 =passwordDaoImp.getAllEmail(request);
		request.setAttribute("emailList", list1);
		request.getRequestDispatcher("/WEB-INF/password.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
