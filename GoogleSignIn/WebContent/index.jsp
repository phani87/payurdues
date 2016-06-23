<%@page import="com.payurdues.login.GoogleAuthHelper"%>
<%@page import="com.payurdues.login.FBConnectionHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	FBConnectionHelper fbConnection = new FBConnectionHelper();
%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Sans-Serif;
	margin: 1em;
}
.oauthDemo a {
	display: block;
	border-style: solid;
	border-color: #bbb #888 #666 #aaa;
	border-width: 1px 2px 2px 1px;
	background: #ccc;
	color: #333;
	line-height: 2;
	text-align: center;
	text-decoration: none;
	font-weight: 900;
	width: 13em;
}
.oauthDemo pre {
	background: #ccc;
}
.oauthDemo a:active {
	border-color: #666 #aaa #bbb #888;
	border-width: 2px 1px 1px 2px;
	color: #000;
}
.readme {
	padding: .5em;
	background-color: #F9AD81;
	color: #333;
}
</style> 
</head>
<body>

<div class="oauthDemo">
		<%
			/*
			 * The GoogleAuthHelper handles all the heavy lifting, and contains all "secrets"
			 * required for constructing a google login url.
			 */
			final GoogleAuthHelper helper = new GoogleAuthHelper();
			if (request.getParameter("code") == null
					|| request.getParameter("state") == null) {
				/*
				 * initial visit to the page
				 */
				out.println("<a href='" + helper.buildLoginUrl()
						+ "'>Google Sign In </a>");
				/* <img src='images/signin.png' height=50px width='250px'> */	
				/*
				 * set the secure state token in session to be able to track what we sent to google
				 */
				session.setAttribute("state", helper.getStateToken());
			} else if (request.getParameter("code") != null && request.getParameter("state") != null
					&& request.getParameter("state").equals(session.getAttribute("state"))) {
				session.removeAttribute("state");
				out.println("<pre>");
				/*
				 * Executes after google redirects to the callback url.
				 * Please note that the state request parameter is for convenience to differentiate
				 * between authentication methods (ex. facebook oauth, google oauth, twitter, in-house).
				 * 
				 * GoogleAuthHelper()#getUserInfoJson(String) method returns a String containing
				 * the json representation of the authenticated user's information. 
				 * At this point you should parse and persist the info.
				 */
				out.println(helper.getUserInfoJson(request.getParameter("code")));
				out.println("</pre>");
			}
		%>
	</div>
	<div
		style="margin: 0 auto; background-image: url(.\images\facebook.png); height: 360px; width: 610px;">
		<a href="<%=fbConnection.getFBAuthUrl()%>"> <img
			style="margin-top: 138px;width: 200px;height: 50px;" src=".\images\facebook.png" />
		</a>
	</div>
	<br />
	<div class="readme">
		<h1>Read Me First</h1>
		
		<h3>Assumptions</h3>

		<ul>
			<li>familiarity with OOP, java, maven, and jee</li>
			<li>java application server listening on localhost:8080</li>
		</ul>

		<h3>Prerequisites</h3>

		<ul>
			<li>Google API access credentials (Client ID, Client Secret).
				Set it up here <a href='https://code.google.com/apis/console/'>https://code.google.com/apis/console/</a>
			</li>
			<li>Set up allowed Redirect URIs at Google API &rarr; API
				Access. Input: http://localhost:8080/OAuth2v1/index.jsp</li>
			<li>a positive outlook on life</li>
		</ul>
		
		<h3>Usage</h3>

		<ol>
			<li>Add Client ID, and Client Secret parameters to <b>GoogleAuthHelper.java</b></li>
			<li>Compile the project (<b>$ mvn clean install</b>)</li>
			<li>Deploy war to application server</li>
			<li>Browse to: <a href="http://localhost:8080/gplus-quickstart-java/">http://localhost:8080/gplus-quickstart-java/</a></li>
			<li>Click <b>&quot;log in with google&quot;</b> on top of this page</li>
		</ol>
		
	</div>
</body>
</html>