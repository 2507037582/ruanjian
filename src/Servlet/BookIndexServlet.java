package Servlet;

import DaoImp.BookDaoImp;
import domain.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class BookIndexServlet extends HttpServlet {
	BookDaoImp bookDaoImp=new BookDaoImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Book> list =bookDaoImp.getAllBook();
		request.setAttribute("bookList", list);
		request.getRequestDispatcher("/WEB-INF/book.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
