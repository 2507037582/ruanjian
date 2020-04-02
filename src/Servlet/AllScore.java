package Servlet;

import DaoImp.Score4DaoImp4;
import domain.Score4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AllScore
 */
public class AllScore extends HttpServlet {
		Score4DaoImp4 score4DaoImp4=new Score4DaoImp4();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			List<Score4> list =score4DaoImp4.getAllScore(request);
			request.setAttribute("allscore4List", list);
			request.getRequestDispatcher("/WEB-INF/allscore.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
