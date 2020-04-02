package service;

import dao.UserDao;
import domain.User;

import java.sql.SQLException;

public class UserService {

	public boolean regist(User user) {
		UserDao dao=new UserDao();
		int row=0;
		try {
			row = dao.regist(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row>0?true:false;
	}

	public boolean checkUsername(String username) {
		UserDao dao=new UserDao();
		Long isExist=0L;
		try {
			isExist=dao.checkUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

	public boolean checkName(String name) {
		UserDao dao=new UserDao();
		Long isExist=0L;
		try {
			isExist=dao.checkName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}
}
