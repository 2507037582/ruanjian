package DaoImp;

import domain.Score4;
import utils.DataSourceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Score4DaoImp4{
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	public List<Score4> getAllScore4(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		String a=(String) session.getAttribute("username");
		ResultSet rs=null;  
		List<Score4> list;
		try {
			conn = DataSourceUtils.getConnection();
			list = new ArrayList<Score4>();
			conn=DataSourceUtils.getConnection();
    		pstmt = conn.prepareStatement("select * from score4 where username=?");
    		pstmt.setString(1, a);
    		rs = pstmt.executeQuery();
			while(rs.next()){
				Score4 score4=new Score4();
				score4.setId(rs.getString("id"));
				score4.setA(rs.getString("a"));
				score4.setB(rs.getString("b"));
				score4.setC(rs.getString("c"));
				score4.setD(rs.getString("d"));
				score4.setE(rs.getString("e"));
				score4.setF(rs.getString("f"));
				score4.setG(rs.getString("g"));
				score4.setH(rs.getString("h"));
				score4.setI(rs.getString("i"));
				score4.setJ(rs.getString("j"));
				score4.setK(rs.getString("k"));
				score4.setL(rs.getString("l"));
				list.add(score4);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Score4> getAllScore(HttpServletRequest request){
		ResultSet rs=null;  
		List<Score4> list;
		try {
			conn = DataSourceUtils.getConnection();
			list = new ArrayList<Score4>();
			conn=DataSourceUtils.getConnection();
    		pstmt = conn.prepareStatement("select * from score4");
    		rs = pstmt.executeQuery();
			while(rs.next()){
				Score4 score4=new Score4();
				score4.setName(rs.getString("name"));
				int a1 = Integer.parseInt(rs.getString("a"));
				if(a1<60) {
					a1=50;
				}
				int b1 = Integer.parseInt(rs.getString("b"));
				if(b1<60) {
					b1=50;
				}
				int c1 = Integer.parseInt(rs.getString("c"));
				if(c1<60) {
					c1=50;
				}
				int d1=0;
				if(rs.getString("d").equals("f")) {
					d1=50;
				}else if(rs.getString("d").equals("d")) {
					d1=65;
				}else if(rs.getString("d").equals("c")) {
					d1=75;
				}else if(rs.getString("d").equals("b")) {
					d1=82;
				}else if(rs.getString("d").equals("a")) {
					d1=95;
				}
				
				int e1 = Integer.parseInt(rs.getString("e"));
				if(e1<60) {
					e1=50;
				}
				int f1 = Integer.parseInt(rs.getString("f"));
				if(f1<60) {
					f1=50;
				}
				int g1 = Integer.parseInt(rs.getString("g"));
				if(g1<60) {
					g1=50;
				}
				int h1 = Integer.parseInt(rs.getString("h"));
				if(h1<60) {
					h1=50;
				}
				int i1=0;
				if(rs.getString("i").equals("f")) {
					i1=50;
				}else if(rs.getString("i").equals("d")) {
					i1=65;
				}else if(rs.getString("i").equals("c")) {
					i1=75;
				}else if(rs.getString("i").equals("b")) {
					i1=82;
				}else if(rs.getString("i").equals("a")) {
					i1=95;
				}
				int j1 = Integer.parseInt(rs.getString("j"));
				if(j1<60) {
				j1=50;
				}
				int k1 = Integer.parseInt(rs.getString("k"));
				if(k1<60) {
					k1=50;
				}
				int l1 = Integer.parseInt(rs.getString("l"));
				float grade;
				grade=(float) ((a1/10-5)*4+(b1/10-5)*2.5+(c1/10-5)*4+(d1/10-5)*2+(e1/10-5)*2+(f1/10-5)*3+(g1/10-5)*2+(h1/10-5)*0.5+(i1/10-5)*4+(j1/10-5)*2+(k1/10-5)*0.5+(l1/10-5)*4);
				score4.setA(rs.getString("a"));
				score4.setB(rs.getString("b"));
				score4.setC(rs.getString("c"));
				score4.setD(rs.getString("d"));
				score4.setE(rs.getString("e"));
				score4.setF(rs.getString("f"));
				score4.setG(rs.getString("g"));
				score4.setH(rs.getString("h"));
				score4.setI(rs.getString("i"));
				score4.setJ(rs.getString("j"));
				score4.setK(rs.getString("k"));
				score4.setL(rs.getString("l"));
				score4.setGrade(grade);
				list.add(score4);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
