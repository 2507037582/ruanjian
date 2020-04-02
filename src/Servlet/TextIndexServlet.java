package Servlet;

import DaoImp.FileDaoImp;
import domain.Text;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class TextIndexServlet extends HttpServlet {
	FileDaoImp fileDaoImp=new FileDaoImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		List<Text> list =fileDaoImp.getAllFile();
		request.setAttribute("textList", list);
		request.getRequestDispatcher("/WEB-INF/text.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
