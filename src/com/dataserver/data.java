package com.dataserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class data {
	
	private static String currentAcc = "";
	private static String currentType= "";
	
	
	public boolean check(String type, String username1, String password1)  throws Exception{
		
		boolean answer = false;
		String query;
		
			query = "SELECT * FROM list." + type +" WHERE user_name =? AND pass_word =?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(ServeriInfo.getUrl(), ServeriInfo.getName1(), ServeriInfo.getPass());
		PreparedStatement st = con.prepareStatement(query);
	//	st.setString(1, type);
		st.setString(1, username1);
		st.setString(2, password1);
		
		ResultSet rs = st.executeQuery();
	while(rs.next()) {
			
		if (rs.getString("user_name").equals(username1) && rs.getString("pass_word").equals(password1)) {
			answer = true;
			data.currentAcc = username1;
			data.currentType = type;
		}
	}
	
		st.close();
		con.close();
		
		}
		catch (SQLException e) {
			System.out.println("error222222");
		}
		return answer;
	}
	
//public boolean check(String type, String username1, String password1)  throws Exception{
//		
//		boolean answer = false;
//		
//		String query = "SELECT * FROM list."+ type +" WHERE user_name = '"+ username1 +"' AND pass_word = '"+ password1 +"';";
//		try {
//		Class.forName("com.mysql.jdbc.Driver");
//		
//		Connection con = DriverManager.getConnection(ServeriInfo.getUrl(), ServeriInfo.getName1(), ServeriInfo.getPass());
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(query);
//		while(rs.next()) {
//		
//		if (rs.getString("user_name").equals(username1) && rs.getString("pass_word").equals(password1)) {
//			answer = true;
//			data.currentAcc = username1;
//			data.currentType = type;
//		}
//		}
//		st.close();
//		con.close();
//		}
//		catch (SQLException e) {
//			System.out.println("error222222");
//		}
//		return answer;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public boolean checkUser(String type, String username1)  throws Exception{
		
		boolean answer = false;
		
		String query = "SELECT * FROM list."+ type +" WHERE user_name = '"+ username1 +"';";
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(ServeriInfo.getUrl(), ServeriInfo.getName1(), ServeriInfo.getPass());
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		if	(rs.getString("user_name").equals(username1)) {
			answer= true;
			}
		}
		st.close();
		con.close();
		}
		catch (SQLException e) {
			System.out.println("error123");
		}
		return answer;
	}
	
public boolean createUser (String type, String username1, String password1)  throws Exception{
	
	boolean answer = false;
	
	String query = "INSERT INTO list."+ type +"(user_name, pass_word) VALUES( '"+username1+"', '"+password1+"');";
	try {
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con = DriverManager.getConnection(ServeriInfo.getUrl(), ServeriInfo.getName1(), ServeriInfo.getPass());
	Statement st = con.createStatement();
	int count = st.executeUpdate(query);
	if(count>0) {
		answer = true;
	}
	st.close();
	con.close();
	}
	catch (SQLException e) {
		System.out.println("error345");
	}
	return answer;
}
	
	
public boolean saveUserData (String text)  throws Exception{
	
	boolean answer = false;
	
	String query = "UPDATE list."+data.currentType+" SET address='"+text+"' WHERE user_name = '"+data.currentAcc+"';";
	
	
	try {
		
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con = DriverManager.getConnection(ServeriInfo.getUrl(), ServeriInfo.getName1(), ServeriInfo.getPass());
	Statement st = con.createStatement();
	int count0 = st.executeUpdate("SET SQL_SAFE_UPDATES = 0;");
	int count = st.executeUpdate(query);
	if(count>0) {
		answer = true;
	}
	st.close();
	con.close();
	}
	catch (SQLException e) {
		System.out.println("error388");
	}
	return answer;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
