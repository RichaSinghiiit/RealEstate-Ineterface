package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdatePropertyDao {
	 static Connection con;
     
	    
	    public static void loadDriver() throws ClassNotFoundException{
	    	Class.forName("com.mysql.jdbc.Driver");
	    }
	    public static Connection getConnection(){
	    	
		    try{
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny","root","papa1602");
		    	
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		    
		    return con;
	    	
	    }
	    public static String insert(booking booked) {
	    	String result="data entered successfully";
	    	
	    	try{
	    		loadDriver();
		    	con=getConnection();
		    	String sql="insert into kxlfgqqgny.booking (property_id,agent_id,client_id,booking_price,first_date,last_date) values(?,?,?,?,?,?)";
		    	
	    		PreparedStatement ps= con.prepareStatement(sql);
	    		
	    		
	    		
	    		
	    			    		
	    		ps.setInt(1,booked.getProperty_id() );
	    		ps.setInt(2, booked.getAgent_id() );
	    		ps.setInt(3, booked.getClient_id() );
	    		ps.setInt(4, booked.getBooking_price() );
	    		ps.setString(5,booked.getFirst_date() );
	    		ps.setString(6, booked.getLast_date());
	    		
	    		
	    		ps.executeUpdate();
	    		  sql="update Property set bookingStatus='Booked' where property_id=?";
	    		  ps=con.prepareStatement(sql);
	    		  ps.setInt(1, booked.getProperty_id());
	    		  ps.executeUpdate();
	    		 
	    	}catch(Exception e){
	    	   e.printStackTrace();	
	    	   result="data can't be recorded";
	    	}
	    	
	    	return result;
	    	
	    }
}
