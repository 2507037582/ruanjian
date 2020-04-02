package Servlet;

import dao.FileDao;
import domain.Text;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class TextServlet extends HttpServlet {
    FileDao fileDao=new FileDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String filename=request.getParameter("filename");
        Text text=new Text();
        text.setFilename(filename);
        System.out.println(filename);
        try {
			fileDao.insert(text);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                response.sendRedirect(request.getContextPath()+"/textindex");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
