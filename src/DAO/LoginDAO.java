package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Models.ClientModel;

public class LoginDAO
{
	public static void loadDriver() throws ClassNotFoundException{
    	Class.forName("com.mysql.jdbc.Driver");
    }
	public  int getUserID(String email, String password, String user) {
		
		Connection connect = null;
		ResultSet resultSet = null;
		Statement statement = null;
		PreparedStatement pStmt =null;
		
		try {
			loadDriver();
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny","root","papa1602");
			
			pStmt = connect.prepareStatement("SELECT * FROM "+ user + " WHERE  email LIKE ? AND password LIKE ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
			pStmt.setString(1, email);
			pStmt.setString(2, password);
			System.out.println(pStmt);
			resultSet = pStmt.executeQuery();
			
			int user_id = 0;
			if(resultSet.next())
			{
				user_id = resultSet.getInt(user+"_id");
			}
			
			System.out.println(user_id);
			return user_id;
		}
		catch (Exception ex) {
			// handle the error
			ex.printStackTrace();
			}
		return 0;
	}
}
