package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.AgentModel;
import Models.PropertyModel;

public class AgentDAO {
	
	public AgentModel getDetails(int agent_id) throws SQLException {
		
		Connection connect = null;
		ResultSet resultSet = null;
		Statement statement = null;
		PreparedStatement pStmt =null;
		
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny", "root", "papa1602");
		
		pStmt = connect.prepareStatement("SELECT * FROM agent WHERE agent_id = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
		pStmt.setInt(1, agent_id); 
		resultSet = pStmt.executeQuery(); 
		
		AgentModel agent = new AgentModel();
		
		if(resultSet.next())
		{
			agent.setName(resultSet.getString("name"));
			agent.setEmail(resultSet.getString("email"));
			agent.setAddress(resultSet.getString("address"));
		}
		
		pStmt = connect.prepareStatement("SELECT * FROM agent_contact WHERE agent_id = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
		pStmt.setInt(1, agent_id); 
		resultSet = pStmt.executeQuery(); 
		
		if(resultSet.next())
		{
			agent.setContact_number(resultSet.getLong("contact_number"));
		}
		
		pStmt = connect.prepareStatement("SELECT P.property_id ,property_for, asking_price, size, house_number, locality,"
				+ " property_type, number_of_bedrooms, number_of_bathrooms, new_or_resale,"
				+ "construction_status, furnishing, parking ,bookingStatus,name,email,contact_number FROM Property P, deals_in D, owner O, owner_contact OC WHERE D.agent_id = ? AND D.property_id = P.property_id AND O.owner_id = P.owner_id AND  OC.owner_id = O.owner_id ;",ResultSet.TYPE_SCROLL_INSENSITIVE);
		pStmt.setInt(1, agent_id); 
		resultSet = pStmt.executeQuery();
		
		List<PropertyModel> deals_in = new ArrayList<PropertyModel>();
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
			property.setBooking_status(resultSet.getString("bookingStatus"));
			//property.setBooking_price(resultSet.getInt("booking_price"));
			property.setOwnercontact_number(resultSet.getLong("contact_number"));
			property.setOwner_email(resultSet.getString("email"));
			property.setOwner_name(resultSet.getString("name"));
			deals_in.add(property);
		}
		agent.setDeals_in(deals_in);
		
		System.out.println(agent.toString());
		return agent;
		
	}
}
