package dao;

import domain.Email;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class EmailDao {
	public int send( Email email) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into email values(?,?,?,?)";
		long l = System.currentTimeMillis();
		Date date=new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int update=runner.update(sql,null,email.getTitle(),email.getContent(),dateFormat.format(date));
		return update;
	}

	public int delete(String id) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from email where id=?";
		int delete=runner.update(sql,id);
		return delete;
	}
}
