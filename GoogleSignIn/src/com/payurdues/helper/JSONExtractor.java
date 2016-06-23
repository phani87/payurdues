package com.payurdues.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.payurdues.business.User;
import com.payurdues.dao.userDAO;
import com.payurdues.db.UserDB;

import org.json.JSONException;

public class JSONExtractor {

	// TODO Auto-generated method stub
	private userDAO userDAO;
	public User user;
	
	public String parseGoogleUser(String json) throws SQLException {
		try {
			// read the json file
			
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
			userDAO = new userDAO();
			user = new User();
			// get a String from the JSON object
			getUserDAO().setUnique_user_id(new RandomIDGenerator().generateProfileID().toString());
			getUserDAO().setFirst_name(jsonObject.get("given_name").toString());
			getUserDAO().setLast_name(jsonObject.get("family_name").toString());
			getUserDAO().setEmail_id(jsonObject.get("email").toString());
			getUserDAO().setProfile_id("$"+jsonObject.get("given_name").toString().toLowerCase()+"."+jsonObject.get("family_name").toString().toLowerCase());
			getUserDAO().setProfile_pic(jsonObject.get("picture").toString());
			getUserDAO().setGmailID(jsonObject.get("id").toString());
			getUserDAO().setFacebookID("");
			user.createUser(userDAO);
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return "Inserted";
	}
	
	public Map getGraphData(String fbGraph) throws SQLException {
		Map fbProfile = new HashMap();
		try {
			org.json.JSONObject json = new org.json.JSONObject(fbGraph);
			fbProfile.put("id", json.getString("id"));
			userDAO dao = new userDAO();
			dao.setFacebookID(json.getString("id"));
			dao.setUnique_user_id("81fccb99733648d9a3390c7016f6ddb1");
			
			/*fbProfile.put("name", json.getString("name"));
			if (json.has("email"))
				fbProfile.put("email", json.getString("email"));
			if (json.has("gender"))
				fbProfile.put("gender", json.getString("gender"));*/
			user = new User();
			user.linkFaceBook(dao);
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return fbProfile;
	}

	public userDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(userDAO userDAO) {
		this.userDAO = userDAO;
	}

}
