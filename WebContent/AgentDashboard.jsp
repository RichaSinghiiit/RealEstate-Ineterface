<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "Models.AgentModel, Models.PropertyModel, Models.BookingModel, Models.OwnerModel, java.util.List" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent Dashboard</title>
</head>

<style>

.profileDetailBox {
  border: 5px outset grey;
  background-color: lightgrey;    
  
}

.properties{
	width: 100%;
	padding: 6px;"
}

</style>

<body>
	<% response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");%><%-- to prevent accessing the page after logout using back button --%>

	<form action="Logout">
   		<input type="submit" value="Logout">
	</form>
	
	<h1 style="text-align:center" >Agent Dashboard</h1>
	<div class="profileDetailBox">
		<% AgentModel agent = (AgentModel)request.getAttribute("agent") ;  
		/*
		AgentModel agent = new AgentModel();
		   agent.setName("AAYUSH MAURYA");
		   agent.setEmail("aayush.maurya@iiitg.ac.in");
		   agent.setContact_number(99129394);
		   //*/
		%>
		<ul>
			<li>Name: <%  out.println(agent.getName()); %></li>
			<li>Contact No: <% out.println(agent.getContact_number()); %></li>
			<li>Email ID: <%  out.println(agent.getEmail()); %> </li>
			<li>Address: <%  out.println(agent.getAddress()); %> </li>
			<li><form action='newProperty.jsp'> <input type='submit' value='Add New Property'></input></form> </li>
		</ul>
	</div>
	<h3 style="background-color: #cce6ff; padding: 8px 15px;" >Properties:</h3>
	
		<% List<PropertyModel> deals_in = agent.getDeals_in();
			if(deals_in.size() != 0)
			{%>
		<table class="properties">
			<tr>
			<th>Price&emsp;</th>
			<th>Address&emsp;</th>
			<th>Property For&emsp;</th>
			<th>Booking Status&emsp;</th>
			<th>Property Type&emsp;</th>
			<th>Construction status&emsp;</th>
			<th>Bedroom(s)&emsp;</th>
			<th>Bathroom(s)&emsp;</th>
			<th>Transaction&emsp;</th>
			<th>Size&emsp;</th>
			<th>Furnishing&emsp;</th>
			<th>Parking&emsp;</th>
			<th>Owner&emsp;</th>
			<th>Owner Contact&emsp;</th>
			
			<th>Update</th>
			</tr>
    		<% for(PropertyModel property: deals_in){%>
					<tr><td><%= property.getAsking_price() %></td>
					    <td><% out.print(property.getProperty_type()+" no- "+property.getHouse_number()+", "+ property.getLocality());%></td>
					    <td><%= property.getProperty_for() %></td>	
					    <td><%= property.getBooking_status() %></td>
					    <td><%= property.getProperty_type() %></td>
					    <td><%= property.getConstruction_status() %></td>
					    <td><%= property.getNumber_of_bedrooms() %></td>
					    <td><%= property.getNumber_of_bathrooms() %></td>
					    <td><%= property.getNew_or_resale() %></td>
					    <td><%= property.getSize() %></td>
						<td><%= property.getFurnishing() %></td>
					    <td><%= property.getParking() %></td>
					    <td><%= property.getOwner_name() %></td>
					    <td><%= property.getOwnercontact_number() %></td>
					    <td><form  action='updateProperty.jsp' method='post'><input type='hidden' name='updatepropertyid' value=<%=property.getProperty_id() %>></input><input type='submit' name='update' value='update'></input></form></td>
					    </tr>
					   
			  <%
    		}
			%>
		</table><% 
		}
		else 
			out.println("You have not added any properties yet");%>


</body>
</html>