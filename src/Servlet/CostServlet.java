package Servlet;

import dao.CostDao;
import domain.Orders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CostServlet extends HttpServlet {
	Orders orders =new Orders();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		CostDao costDao=new CostDao();
		HttpSession session = request.getSession(false);
		String a=(String) session.getAttribute("username");
		HttpSession session1 = request.getSession(false);
		String  b=(String) session1.getAttribute("name");
		
		orders.setUsername(a);
		orders.setName(b);
		//��ñ�����
				try {
					costDao.insert(id,orders);
				} catch (Exception e) {
					e.printStackTrace();
				}
				response.sendRedirect(request.getContextPath()+"/bookindex");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
