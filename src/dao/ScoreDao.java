package dao;

import domain.Score4;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class ScoreDao {
	public int insert(Score4 score4) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into score4 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int update=runner.update(sql,score4.getUsername(),score4.getName(),null,score4.getA(),score4.getB(),score4.getC(),score4.getD(),score4.getE(),score4.getF(),score4.getG(),score4.getH(),score4.getI(),score4.getJ(),score4.getK(),score4.getL());
		return update;
	}
	public int delete(String id) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from score4 where id=?";
		int delete=runner.update(sql,id);
		return delete;
	}
}
