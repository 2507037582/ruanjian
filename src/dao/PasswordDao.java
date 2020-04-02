package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class PasswordDao {
	public int update(String username,String password) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update user set password=? where username=?";
		int update=runner.update(sql,password,username);
		return update;
	}
	
	public int update1(String username,String email) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update user set email=? where username=?";
		int update=runner.update(sql,email,username);
		return update;
	}
}
