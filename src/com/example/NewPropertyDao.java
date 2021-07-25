package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewPropertyDao {
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
	    public static String insert(property prop, owner owns,int agent_id) {
	    	String result="new property entered successfully";
	    	int owner_id=0;
	    	try{
	    		loadDriver();
		    	con=getConnection();
		    	String sql="insert into kxlfgqqgny.property (owner_id,property_for,asking_price,size,house_number,locality,property_type,number_of_bedrooms,number_of_bathrooms,new_or_resale,construction_status,furnishing,parking,bookingStatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		    	String owner_sql="select owner_id from owner where email = ? and name=?";
	    		PreparedStatement ps= con.prepareStatement(sql);
	    		PreparedStatement ps1=con.prepareStatement(owner_sql);
	    		ps1.setString(1, owns.getEmail());
	    		ps1.setString(2, owns.getName());
	    		ResultSet rs= ps1.executeQuery();
	    		if(!rs.next()){
	    			String password="1234";
	    			String new_owner_sql="insert into kxlfgqqgny.owner (name,email,password,address) values (?,?,?,?) ";
	    			PreparedStatement ps2=con.prepareStatement(new_owner_sql);
	    			ps2.setString(1, owns.getName());
	    			ps2.setString(2, owns.getEmail());
	    			ps2.setString(3, password);
	    			ps2.setString(4, owns.getAddress());
	    			ps2.executeUpdate();
	    			String new_owner_id_sql="select owner_id from owner where name=? and email=?";
	    			PreparedStatement ps5=con.prepareStatement(new_owner_id_sql);
	    			ps5.setString(1, owns.getName());
		    		ps5.setString(2, owns.getEmail());
	    			ResultSet rs1=ps5.executeQuery();
	    			if(rs1.next()){
	    			owner_id=rs1.getInt("owner_id");
	    			}
	    			String owner_contact="insert into kxlfgqqgny.owner_contact values (?,?)";
	    			PreparedStatement ps4=con.prepareStatement(owner_contact);
	    			ps4.setInt(1, owner_id);
	    			ps4.setString(2, owns.getContact_number());
	    			ps4.executeUpdate();
	    		}else{
	    			owner_id=rs.getInt("owner_id");

	    		}
	    			    		
	    		ps.setInt(1,owner_id );
	    		ps.setString(2, prop.getProperty_for());
	    		ps.setInt(3, prop.getAsking_price());
	    		ps.setInt(4, prop. getSize());
	    		ps.setInt(5, prop. getHouse_number());
	    		ps.setString(6, prop.getLocality());
	    		ps.setString(7, prop.getProperty_type());
	    		ps.setInt(8, prop.getNumber_of_bedrooms());
	    		ps.setInt(9, prop.getNumber_of_bathrooms());
	    		ps.setString(10, prop.getNew_or_resale());
	    		ps.setString(11, prop.getConstruction_status());
	    		ps.setString(12, prop.getFurnishing());
	    		ps.setInt(13, prop.getParking());
	    		ps.setString(14, prop.getBookingStatus());
	    		
	    		ps.executeUpdate();
	    		 int property_id=-1;
	    		 String deals_sql="insert into kxlfgqqgny.deals_in values (?,?)";
	    		 PreparedStatement ps3= con.prepareStatement(deals_sql);
	    		 String count="select * from property where property_id=(select max(property_id) from Property)";
	    		 PreparedStatement ps4= con.prepareStatement(count);
	    		 rs=ps4.executeQuery();
	    		 if(rs.next()){
	    			 property_id=rs.getInt("property_id");
	    		 }
	             ps3.setInt(1, property_id);
	             ps3.setInt(2, agent_id);
	           
	             ps3.executeUpdate();
	              // out.println("successfully bookmarked");
	    	}catch(Exception e){
	    	   e.printStackTrace();	
	    	   result="data can't be recorded";
	    	}
	    	
	    	return result;
	    	
	    }
}
