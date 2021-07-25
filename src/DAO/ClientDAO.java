package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.ClientModel;
import Models.PropertyModel;

public class ClientDAO 
{
	public static void loadDriver() throws ClassNotFoundException{
    	Class.forName("com.mysql.jdbc.Driver");
    }
	public  ClientModel getDetails(int client_id) {
		Connection connect = null;
		ResultSet resultSet = null;
		Statement statement = null;
		PreparedStatement pStmt =null;
		
		try {
			loadDriver();
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny", "root", "papa1602");
			
			pStmt = connect.prepareStatement("SELECT * FROM Client WHERE client_id = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
			pStmt.setInt(1, client_id); 
			resultSet = pStmt.executeQuery(); 
			
			ClientModel client = new ClientModel();
			if(resultSet.next())
			{
				client.setName(resultSet.getString("name"));
				client.setEmail(resultSet.getString("email"));
				client.setAddress(resultSet.getString("address"));
			}
			
			pStmt = connect.prepareStatement("SELECT * FROM client_contact WHERE client_id = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
			pStmt.setInt(1, client_id); 
			resultSet = pStmt.executeQuery(); 
			
			if(resultSet.next())
			{
				client.setContact_number(resultSet.getLong("contact_number"));
			}
			
			pStmt = connect.prepareStatement("SELECT P.property_id,property_for, asking_price, size, house_number, locality,"
					+ " property_type, number_of_bedrooms, number_of_bathrooms, new_or_resale,"
					+ "construction_status, furnishing, parking,name,contact_number,email FROM Property P, interested_in I, deals_in D, Agent A,agent_contact AC WHERE I.client_id = ? AND I.property_id = P.property_id and D.property_id=P.property_id and D.agent_id=A.agent_id and A.agent_id=AC.agent_id;",ResultSet.TYPE_SCROLL_INSENSITIVE);
			pStmt.setInt(1, client_id); 
			resultSet = pStmt.executeQuery();
			
			List<PropertyModel> interested_in = new ArrayList<PropertyModel>();
			while(resultSet.next())
			{
				PropertyModel property = new PropertyModel();
				property.setProperty_id(resultSet.getInt("property_id"));
				property.setAsking_price(resultSet.getInt("asking_price"));
				property.setConstruction_status(resultSet.getString("construction_status"));
				property.setFurnishing(resultSet.getString("furnishing"));
				property.setHouse_number(resultSet.getInt("house_number"));
				property.setLocality(resultSet.getString("locality"));
				property.setNew_or_resale(resultSet.getString("new_or_resale"));
				property.setNumber_of_bathrooms(resultSet.getInt("number_of_bathrooms"));
				property.setNumber_of_bedrooms(resultSet.getInt("number_of_bedrooms"));
				property.setParking(resultSet.getInt("parking"));
				property.setProperty_for(resultSet.getString("property_for"));
				property.setProperty_type(resultSet.getString("property_type"));
				property.setSize(resultSet.getInt("size"));
				property.setContact_number(resultSet.getLong("contact_number"));
				property.setEmail(resultSet.getString("email"));
				property.setName(resultSet.getString("name"));
				interested_in.add(property);
			}
			client.setInterested_in(interested_in);
			
			System.out.println(client.toString());
			return client;
		}
		catch (Exception ex) {
			// handle the error
			ex.printStackTrace();
			}
		return null;
	}
			
		
}
