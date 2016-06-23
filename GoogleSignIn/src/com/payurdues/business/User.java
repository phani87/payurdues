package com.payurdues.business;

import java.sql.SQLException;
import java.util.logging.Logger;

import com.payurdues.dao.userDAO;
import com.payurdues.db.UserDB;
import com.payurdues.db.helper.DBConnector;

public class User implements IUser{

	public UserDB userdb;
	Logger logger = Logger.getLogger(User.class.getName());
	@Override
	public void createUser(userDAO dao) throws SQLException {
		logger.info("------User.createUser()------");
		userdb = new UserDB();
		userdb.createUser(dao);
	}
	@Override
	public void linkFaceBook(userDAO dao) throws SQLException {
		logger.info("------User.linkFaceBook()------");
		userdb = new UserDB();
		userdb.linkFacebook(dao);
	}

}
