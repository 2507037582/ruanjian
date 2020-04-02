package DaoImp;

import domain.Book;
import utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BookDaoImp {
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	public List<Book> getAllBook(){
		
		List<Book> list;
		try {
			conn = DataSourceUtils.getConnection();
			
			list = new ArrayList<Book>();
			
			String sql="select * from book";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Book book=new Book();
				book.setId(rs.getString("id"));
				book.setCourse_name(rs.getString("course_name"));
				book.setCourse_type(rs.getString("course_type"));
				book.setMajor(rs.getString("major"));
				book.setGrade(rs.getString("grade"));
				book.setTeacher(rs.getString("teacher"));
				book.setBook_name(rs.getString("book_name"));
				book.setAuthor(rs.getString("author"));
				book.setTimes(rs.getString("times"));
				book.setPublish(rs.getString("publish"));
				list.add(book);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
