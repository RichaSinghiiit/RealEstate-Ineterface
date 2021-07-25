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
import DAO.ClientDAO;
import Models.ClientModel;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet 
{
	
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		 PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
		 int client_id = (int)session.getAttribute("userID");
		 out.println(client_id);
		 try{
		 ClientDAO dao = new ClientDAO();
		 
		 ClientModel client = dao.getDetails(client_id);
		 
		 
		 request.setAttribute("client", client);
		 out.println(client.getName());
		 }catch(Exception E){
			 E.printStackTrace();
		 }
		 RequestDispatcher reqDispatcher = request.getRequestDispatcher("userProfile.jsp");
		 reqDispatcher.forward(request,response);
		 
	 }

}
