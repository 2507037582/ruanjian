package Servlet;

import DaoImp.CostDaoImp;
import domain.Orders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CostIndexServlet
 */
public class CostIndexServlet extends HttpServlet {
	CostDaoImp costDaoImp=new CostDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Orders> list =costDaoImp.getAllCost(request);
		request.setAttribute("costList", list);
		request.getRequestDispatcher("/WEB-INF/cost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
