package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Servlet implementation class deleteProperties
 */
@WebServlet("/deleteProperties")
public class deleteProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteProperties() {
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
		HttpSession session = request.getSession();
		PrintWriter out= response.getWriter();
		int property_id_delete= Integer.parseInt(request.getParameter("deletepropertyid"));
		out.println(property_id_delete);
		int client_id = (int)session.getAttribute("userID");
		out.println(client_id);
		Connection con;
	    PreparedStatement pst;
	    ResultSet rs;
		try{
		Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny","root","papa1602");
		String deletesql="delete from interested_in where client_id=? and property_id=?";
        pst=con.prepareStatement(deletesql);
        pst.setInt(1, client_id);
        pst.setInt(2, property_id_delete);
        pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("userProfile");
		 reqDispatcher.forward(request,response);
	}

}
