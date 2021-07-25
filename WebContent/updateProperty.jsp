<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");%><%-- to prevent accessing the page after logout using back button --%>

	<form action="Logout">
   		<input type="submit" value="Logout">
	</form>
<div>
<h2>Update Property</h2>
<form method="post" action="update">
<label>Booking Status</label>
<input type="radio" name="status" value="Booked" required></input>
<label for="Booked">Booked</label>


<br><br>
<label>Client ID</label>
<input type="text" name="client_id"></input>
<br><br>
<label>Property ID</label>
<input type="text" name="property_id"  value=<%=request.getParameter("updatepropertyid") %>></input>
<br><br>
<label>Agent ID</label>
<input type="text" name="agent_id"  value=<%=session.getAttribute("userID") %>></input>
<br><br>
<label>Price Booked at</label>
<input type="text" name="booking_price"></input>

<br><br>  
 <label>Date</label>
 <input type="date" name="first_date" ></input>
 <br><br>
 <label>Last Date (only for rented properties)</label>
 <input type="date" name="last_date" ></input>
 <br><br>
 <input type="submit"></input>
</form>
</div>
</body>
</html>