<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login Page</title>
</head>
<body>
<h1>User Login Page</h1><br>
<div>
	<form action="loginServlet" method="post">
		<label> I am a: </label>
	
		<input type="radio" id="client" name="user" value="client" >
		<label for="client">Client</label>
	
		<input type="radio" id="agent" name="user" value="agent">
		<label for="agent">Agent</label>
		<%
   		if(null!=request.getAttribute("errorMessage2"))
    	{
   			%><br><%
        	out.println(request.getAttribute("errorMessage2"));
    	}
		%>	
		<br><br>

		<label>Email ID:</label> 
		<input type="text" name="email"><br><br>

		<label>Password:</label>
 		<input type="password" name="password"><br><br>

		<input type="submit" name="login" value="Login">
		<input type="submit" name ="newUser" value="New User">
	</form>	
	<%
   		if(null!=request.getAttribute("errorMessage1"))
    	{
        	out.println(request.getAttribute("errorMessage1"));
    	}
	%>	
</div>
</body>
</html>