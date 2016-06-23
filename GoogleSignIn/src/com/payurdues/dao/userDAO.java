package com.payurdues.dao;

public class userDAO {

	private String unique_user_id;
	private String profile_id;
	private String email_id;
	private String pwd;
	private String first_name;
	private String last_name;
	private String profile_pic;
	private String gmailID;
	private String facebookID;
	
	
	public String getUnique_user_id() {
		return unique_user_id;
	}
	public void setUnique_user_id(String user_name) {
		this.unique_user_id = user_name;
	}
	public String getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	public String getGmailID() {
		return gmailID;
	}
	public void setGmailID(String gmailID) {
		this.gmailID = gmailID;
	}
	public String getFacebookID() {
		return facebookID;
	}
	public void setFacebookID(String facebookID) {
		this.facebookID = facebookID;
	}
}
