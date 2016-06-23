package com.payurdues.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.payurdues.business.User;
import com.payurdues.dao.userDAO;
import com.payurdues.db.helper.DBConnector;

public class UserDB {
	Logger logger = Logger.getLogger(UserDB.class.getName());
	public DBConnector connector = new DBConnector();
	public Statement statement;
	public void createUser(userDAO userDAO) throws SQLException{
		Connection conn = null;
		try {
			conn = connector.connectToDB();
			statement = conn.createStatement();
			String sql = "INSERT INTO users(uniqueProfileID, profileID, pwd, profilePic, firstName, lastName, gmailID, facebookID) VALUES ('"
					+ userDAO.getUnique_user_id() + "', '" + userDAO.getProfile_id() + "', '" + userDAO.getPwd() + "', '"
					+ userDAO.getProfile_pic() + "', '" + userDAO.getFirst_name() + "', '" + userDAO.getLast_name() +"', '"+ userDAO.getGmailID()+ "', '"+ userDAO.getFacebookID()+"')";
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			logger.info("=====Close Conn=====");
			statement.close();
			conn.close();
		}
	}
	
	public void linkFacebook(userDAO userDAO) throws SQLException{
		Connection conn = null;
		try {
			conn = connector.connectToDB();
			statement = conn.createStatement();
			String sql = "UPDATE users SET facebookID = '"+userDAO.getFacebookID()+"' WHERE uniqueProfileID='"+userDAO.getUnique_user_id()+"'";
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			logger.info("=====Close Conn=====");
			statement.close();
			conn.close();
		}
	}

}
