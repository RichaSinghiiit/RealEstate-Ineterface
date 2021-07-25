package com.example;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class display extends HttpServlet 
{
     int i;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            i++;
            int max=-1;
            int min=-1;
            String type="";
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            if(!request.getParameter("combo").isEmpty())
             type= request.getParameter("combo");
            String locality=request.getParameter("locality");
            if(!request.getParameter("min").isEmpty())
             min=Integer.parseInt(request.getParameter("min"));
            if(!request.getParameter("max").isEmpty())
             max= Integer.parseInt(request.getParameter("max"));
            
            String propertyfor=request.getParameter("for");
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny","root","papa1602");
            if(max!=-1 && min!=-1 && type!=""){
            pst = con.prepareStatement("select property_id,property_type,house_number,locality,size,asking_price,number_of_bedrooms,number_of_bathrooms from property where property_type=? and locality like ? and asking_price between ? and ? and property_for=?");
            pst.setString(1, type);
            pst.setString(2, "%" +locality+"%");
            pst.setInt(3, min);
            pst.setInt(4, max);
            pst.setString(5,propertyfor);
            rs = pst.executeQuery();
            }else{
            	pst = con.prepareStatement("select property_id,property_type,house_number,locality,size,asking_price,number_of_bedrooms,number_of_bathrooms from property where  locality like ?  and property_for=?");
            	//pst.setString(1, type);
                pst.setString(1, "%" +locality+"%");
                
                pst.setString(2,propertyfor);
                rs = pst.executeQuery();
            }
             out.println("<table width=60% border= 1   >");
             out.println("<tr><td colspan=4 " );
             out.println("<center><h2>Result of Search Page</h2></center>");
             out.println("</td></tr>");
             
             if(rs.next()) {
            	 out.println("<tr>");
            	 out.println("<th>Property Id</th>");
            	 out.println("<th>Property Type</th>");
            	 out.println("<th>House Number</th>");
            	 out.println("<th>Locality</th>");
            	 out.println("<th>Size</th>");
            	 out.println("<th>Asking Price in INR</th>");
            	 out.println("<th>No. of Bedrooms</th>");
            	 out.println("<th>No.of Bathrooms</th>");
            	 out.println("<th>Bookmark</th>");
            	 out.println("</tr>");
              
            	 while(rs.next())
            	 {
            		 out.println("<tr>");
            		 out.println("<td>" + rs.getString("property_id") + "</td> ");
            		 out.println("<td>" + rs.getString("property_type") + "</td> ");
            		 out.println("<td>" + rs.getString("house_number") + "</td> ");
            		 out.println("<td>" + rs.getString("locality") + "</td> ");
            		 out.println("<td>" + rs.getString("size") + "</td> ");
            		 out.println("<td>" + rs.getString("asking_price") + "</td> ");
            		 out.println("<td>" + rs.getString("number_of_bedrooms") + "</td> ");
            		 out.println("<td>" + rs.getString("number_of_bathrooms") + "</td> ");
            		 out.println("<td><form method='post' action='InterestedProperties'><input type='hidden' name='propertyid' value='"+rs.getString("property_id")+"'></input><input type='submit' name='bookmark' value='mark it'></input></form></td> ");
            		 out.println("</tr>");

                  
            	 }
            	 out.println("</table>");
             }
             else
             {	out.println("</table>");
            	out.println("<p> No results found! </p>");
             }
            
        } 
        catch (ClassNotFoundException ex) {
        	
        }catch (Exception e) 
        { throw new ServletException("error", e); }
    }  
}

