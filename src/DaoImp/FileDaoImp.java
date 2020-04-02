package DaoImp;

import domain.Text;
import utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FileDaoImp {
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	public List<Text> getAllFile(){
		
		List<Text> list;
		try {
			conn = DataSourceUtils.getConnection();
			
			list = new ArrayList<Text>();
			
			String sql="select * from file";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Text file=new Text();
				file.setId(rs.getString("id"));
				file.setFilename(rs.getString("filename"));
				list.add(file);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
