package com.payurdues.business;

import java.sql.SQLException;

import com.payurdues.dao.userDAO;

public interface IUser {


	public void createUser(userDAO dao) throws SQLException;
	public void linkFaceBook(userDAO dao) throws SQLException;
	
}
