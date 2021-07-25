package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewUserDAO
{ 
	public static void loadDriver() throws ClassNotFoundException{
    	Class.forName("com.mysql.jdbc.Driver");
    }
	public  int addUser(String user, String name, long contact_number, String email, String password, String address )
	{
		Connection connect = null;
		ResultSet resultSet = null;
		Statement statement = null;
		PreparedStatement pStmt =null;
		
		try {
			loadDriver();
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny","root","papa1602");
		
			
			pStmt = connect.prepareStatement("SELECT * FROM "+ user + " WHERE  email LIKE ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
			pStmt.setString(1, email);
			System.out.println(pStmt);
			resultSet = pStmt.executeQuery();
			
			if(resultSet.next())
			{
				return -1;//user with given email id already exists
			}
			
			pStmt = connect.prepareStatement("INSERT INTO kxlfgqqgny." + user +" (name, email, password, address) VALUES (?,?,?,?)");
			pStmt.setString(1, name);
			pStmt.setString(2, email);
			pStmt.setString(3, password);
			pStmt.setString(4, address);
			System.out.println(pStmt);
			pStmt.executeUpdate();
			
			pStmt = connect.prepareStatement("SELECT * FROM "+ user + " WHERE  email LIKE ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
			pStmt.setString(1, email);
			System.out.println(pStmt);
			resultSet = pStmt.executeQuery();
			int user_id = 0;
			if(resultSet.next())
			{
				user_id = resultSet.getInt(user+"_id");
				pStmt = connect.prepareStatement("INSERT INTO " + user +"_contact ("+user+"_id, contact_number) VALUES (?,?)");
				pStmt.setInt(1, user_id);
				pStmt.setLong(2, contact_number);
				
			}
				
		}
		catch (Exception ex) {
			// handle the error
			ex.printStackTrace();
			}
		return 0;
	}
}
