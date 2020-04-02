package Servlet;

import dao.ScoreDao;
import domain.Score4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Score4Servlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ñ�����
		ScoreDao scoreDao=new ScoreDao();
		Score4 score4=new Score4();
		HttpSession session = request.getSession(false);
		String username=(String) session.getAttribute("username");
		HttpSession session1 = request.getSession(false);
		String name=(String) session1.getAttribute("name");
		String a=request.getParameter("a");
		String b=request.getParameter("b");
		String c=request.getParameter("c");
		String d=request.getParameter("d");
		String e=request.getParameter("e");
		String f=request.getParameter("f");
		String g=request.getParameter("g");
		String h=request.getParameter("h");
		String i=request.getParameter("i");
		String j=request.getParameter("j");
		String k=request.getParameter("k");
		String l=request.getParameter("l");
		int a1 = Integer.parseInt(a);
		if(a1<60) {
			a1=50;
		}
		int b1 = Integer.parseInt(b);
		if(b1<60) {
			b1=50;
		}
		int c1 = Integer.parseInt(c);
		if(c1<60) {
			c1=50;
		}
		int d1=0;
		if(d.equals("f")) {
			d1=50;
		}else if(d.equals("d")) {
			d1=65;
		}else if(d.equals("c")) {
			d1=75;
		}else if(d.equals("b")) {
			d1=82;
		}else if(d.equals("a")) {
			d1=95;
		}
		
		int e1 = Integer.parseInt(e);
		if(e1<60) {
			e1=50;
		}
		int f1 = Integer.parseInt(f);
		if(f1<60) {
			f1=50;
		}
		int g1 = Integer.parseInt(g);
		if(g1<60) {
			g1=50;
		}
		int h1 = Integer.parseInt(h);
		if(h1<60) {
			h1=50;
		}
		int i1=0;
		if(i.equals("f")) {
			i1=50;
		}else if(i.equals("d")) {
			i1=65;
		}else if(i.equals("c")) {
			i1=75;
		}else if(i.equals("b")) {
			i1=82;
		}else if(i.equals("a")) {
			i1=95;
		}
		int j1 = Integer.parseInt(j);
		if(j1<60) {
		j1=50;
		}
		int k1 = Integer.parseInt(k);
		if(k1<60) {
			k1=50;
		}
		int l1 = Integer.parseInt(l);
		if(l1<60) {
			l1=50;
		}
		float grade;
		grade=(float) ((a1/10-5)*4+(b1/10-5)*2.5+(c1/10-5)*4+(d1/10-5)*2+(e1/10-5)*2+(f1/10-5)*3+(g1/10-5)*2+(h1/10-5)*0.5+(i1/10-5)*4+(j1/10-5)*2+(k1/10-5)*0.5+(l1/10-5)*4);
		score4.setUsername(username);
		score4.setName(name);
		score4.setA(a);
		score4.setB(b);
		score4.setC(c);
		score4.setD(d);
		score4.setE(e);
		score4.setF(f);
		score4.setG(g);
		score4.setH(h);
		score4.setI(i);
		score4.setJ(j);
		score4.setK(k);
		score4.setL(l);
		score4.setGrade(grade);
		try {
			scoreDao.insert(score4);
		} catch (SQLException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/score4index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
