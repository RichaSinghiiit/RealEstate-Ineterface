<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "Models.ClientModel, Models.PropertyModel, java.util.ArrayList, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>
	<% response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");%><%-- to prevent accessing the page after logout using back button --%>

	<form action="Logout">
   		<input type="submit" value="Logout">
	</form>
	<h1>User Profile</h1>
	<div class="profileDetailBox">
		<% ClientModel client = (ClientModel)request.getAttribute("client") ; 
		  
		/*ClientModel client = new ClientModel();
		   client.setName("VIKAS DHAYAL");
		   client.setEmail("vikas.dhayal.@iiitg.ac.in");
		   client.setContact_number(99129394);*/
		 
		%>
		<ul>
			<li>Name: <%  out.println(client.getName()); %></li>
			<li>Contact No: <% out.println(client.getContact_number()); %></li>
			<li>Email ID: <%  out.println(client.getEmail()); %> </li>
			<li>Address: <%  out.println(client.getAddress()); %> </li>
		</ul>
	</div>
	<h3>Bookmarked Properties:</h3>
		<%List<PropertyModel> interested_in = client.getInterested_in();
		if(interested_in.size() != 0)
			{%>
		<table>
			<tr>
			<th>Price</th>
			<th>Address</th>
			<th>Property For</th>
			<th>Type</th>
			<th>Construction status</th>
			<th>Bedroom(s)</th>
			<th>Bathroom(s)</th>
			<th>Transaction</th>
			<th>Size</th>
			<th>Furnishing</th>
			<th>Parking</th>
			<th>Agent Name</th>
			<th>Agent Contact Number</th>
			<th>Delete</th>
						</tr>
    		<% for(PropertyModel property: interested_in){
				%>
					<tr><td><%= property.getAsking_price() %></td>
					    <td><% out.print(property.getProperty_type()+" no- "+property.getHouse_number()+", "+ property.getLocality());%></td>
					    <td><%= property.getProperty_for() %></td>	
					    <td><%= property.getProperty_type() %></td>
					    <td><%= property.getConstruction_status() %></td>
					    <td><%= property.getNumber_of_bedrooms() %></td>
					    <td><%= property.getNumber_of_bathrooms() %></td>
					    <td><%= property.getNew_or_resale() %></td>
					    <td><%= property.getSize() %></td>
						<td><%= property.getFurnishing() %></td>
					    <td><%= property.getParking() %></td>
					    <td><%= property.getName() %></td>
					    <td><%= property.getContact_number() %></td>
					    <td><form method='post' action='deleteProperties'><input type='hidden' name='deletepropertyid' value=<%=property.getProperty_id() %>></input><input type='submit' name='delete' value='delete'></input></form></td>
					    </tr> 
					    
					    
					    <% 
    			}%>	
		</table><% 
		}
		else 
			out.println("You have not bookmarked any properties yet");%>
		
</body>
</html>