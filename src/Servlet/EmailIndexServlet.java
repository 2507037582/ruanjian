package Servlet;

import DaoImp.EmailDaoImp;
import domain.Email;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class EmailIndexServlet
 */
public class EmailIndexServlet extends HttpServlet {
	EmailDaoImp emailDaoImp=new EmailDaoImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Email> list =emailDaoImp.getAllEmail();
		List<Email> list1 =emailDaoImp.getFirstEmail();
		request.setAttribute("emailList", list);
		request.setAttribute("firstList", list1);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
