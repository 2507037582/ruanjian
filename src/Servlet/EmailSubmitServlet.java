package Servlet;

import dao.EmailDao;
import domain.Email;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class EmailSubmitServlet extends HttpServlet {
	EmailDao emailDao=new EmailDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ñ�����
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Email email = new Email();
		email.setTitle(title);
		email.setContent(content);
		try {
			emailDao.send(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/emailindex");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
