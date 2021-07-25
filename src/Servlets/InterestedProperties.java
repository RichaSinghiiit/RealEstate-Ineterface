package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InterestedProperties
 */
@WebServlet("/InterestedProperties")
public class InterestedProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterestedProperties() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		 
		int property_id= Integer.parseInt(request.getParameter("propertyid"));
		
		out.println(property_id);
		int client_id = (int)session.getAttribute("userID");
		out.println(client_id);
		Connection con;
	    PreparedStatement pst;
	    ResultSet rs;
	    try{
		   Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny","root","papa1602");
           String query="select * from interested_in where client_id=? and property_id=?";
           pst=con.prepareStatement(query);
           pst.setInt(1, client_id);
           pst.setInt(2, property_id);
           rs=pst.executeQuery();
           if(rs.next()){
        	   out.println("property already bookmarked");
           }else{
               String sql="insert into kxlfgqqgny.interested_in values (?,?)";
               pst=con.prepareStatement(sql);
               pst.setInt(1, client_id);
               pst.setInt(2, property_id);
           
               pst.executeUpdate();
               out.println("successfully bookmarked");
           }
        
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	    RequestDispatcher reqDispatcher = request.getRequestDispatcher("userProfile");
		 reqDispatcher.forward(request,response);
	}

}
