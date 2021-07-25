<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Property</h1>
<form  action="NewProperty" method="post">
   <label>Property For:</label>
   <select name="property_for">
   <option>Sale</option>
   <option>Rent</option>
   </select> 
   <br>
   <br>
   <label>Property Type:</label>
   <select name="property_type">
   <option>House</option>
   <option>Apartment</option>
   <option>Villa</option>
   <option>Bunglow</option>
   </select> 
   <br>
   <br>
   <label>Address:</label>
   <br>
   <label>Line 1:</label>
   <input name="house_number" placeholder="House No."></input>
   <br>
   <br>
   <label>Line 2:</label>
   <input name="locality" placeholder="Locality"></input>
   <br><br>
   <label>No. of Bedrooms</label>
   <input name="number_of_bedrooms" type="number"></input>
   <label>No. of Bathrooms</label>
   <input name="number_of_bathrooms" type="number"></input>
   <br>
   <br>
   <label>Size(in sq.ft)</label>
   <input name="size" placeholder="size"></input>
   <label>Asking price</label>
   <input name="asking_price" placeholder="price"></input>
   <br><br>
   
   <label>No. of Parkings</label>
   <input type="number" name="parking"></input>
   <br><br>

   <label>New or Resale</label>
   <select name="new_or_resale">
     <option>New</option>
     <option>Resale</option>
   </select>
   <br><br>
   <label>Furnished :</label>
   <select name="furnishing">
     <option>Yes</option>
     <option>No</option>
   </select>
   <label>Construction Status:</label>
   <select name="construction_status">
    <option>Completed</option>
    <option>Under Construction</option>
   </select>
   <label>Booking Status:</label>
   <select name="booking_status">
    <option>Available</option>
    <option>Booked</option>
   </select>
   
   <div>
    <h4>Owner's details</h4>
    <label>Name</label>
    <input type=text name="name"></input>
    <label>Contact Number</label>
    <input type=text name="contact_number"></input>
    
    <label>Email id</label>
     <input type="email" name="email"></input>
     <label>Address</label>
    <input type=text name="address"></input>
   </div>
   <br>
   
   <input type="submit"></input>
</form>
</body>
</html>