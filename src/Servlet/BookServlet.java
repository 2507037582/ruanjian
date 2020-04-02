package Servlet;

import dao.BookDao;
import domain.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class BookServlet extends HttpServlet {
	BookDao bookDao=new BookDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String a=(String) session.getAttribute("username");
		//��ñ�����
		String course_name=request.getParameter("course_name");
		String course_type=request.getParameter("course_type");
		String major=request.getParameter("major");
		String grade=request.getParameter("grade");
		String teacher=request.getParameter("teacher");
		String book_name=request.getParameter("book_name");
		String author=request.getParameter("author");
		String times=request.getParameter("times");
		String publish=request.getParameter("publish");
		Book book=new Book();
		book.setCourse_name(course_name);
		book.setCourse_type(course_type);
		book.setMajor(major);
		book.setGrade(grade);
		book.setTeacher(teacher);
		book.setBook_name(book_name);
		book.setAuthor(author);
		book.setTimes(times);
		book.setPublish(publish);
			try {
				bookDao.insert(book);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		response.sendRedirect(request.getContextPath()+"/bookindex");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
