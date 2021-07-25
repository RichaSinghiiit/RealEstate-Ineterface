<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="newUserServlet" method="post">
		<label> I am a: </label>
	
		<input type="radio" id="client" name="user" value="client" required>
		<label for="client">Client</label>
	
		<input type="radio" id="agent" name="user" value="agent">
		<label for="agent">Agent</label><br><br>
		
		<label>Name: </label>
		<input type="text" name="name" required><br><br>
		
		<label>Email id:</label>
		<input type="email" name="email" required>
			<%
   		if(null!=request.getAttribute("errorMessage"))
    	{
   			%><br><%
        	out.println(request.getAttribute("errorMessage"));
    	}
	%>	
		<br><br>
		
		<label>Password: </label>
		<input type="password" name="password" required><br><br>
		
		<label>Contact Number: </label>
		<input type="text" name="number" required><br><br>
		
		<label>Address</label>
		<input type="text" name="address" required><br><br>
		
		<input type="submit" value="Submit">
</form>
		
</body>
</html>