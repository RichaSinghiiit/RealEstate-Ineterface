package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;


@WebServlet("/loginServlet")

public class LoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	 {
		 HttpSession session = request.getSession();
		 
		 if(request.getParameter("newUser") != null)
		 {
			 response.sendRedirect("NewUser.jsp");
		 }
		 else
		 {
			 if(request.getParameter("user")!= null)
			 {
				 session.setAttribute("user", request.getParameter("user"));
				 System.out.println(session.getAttribute("user"));
			 
				 String email = request.getParameter("email");
				 email = email.trim();
				 String password = request.getParameter("password");
				 password = password.trim();
				 String user = (String) session.getAttribute("user");
			 
				 LoginDAO dao = new LoginDAO();
			 
				 int userID = dao.getUserID(email, password, user);
				 if(userID != 0 && request.getParameter("user").equals("client"))
				 {
					 session.setAttribute("userID", userID);
					 response.sendRedirect("search.jsp");
				 }else if(userID != 0 && request.getParameter("user").equals("agent")){
					 session.setAttribute("userID", userID);
					 response.sendRedirect("AgentDashboard");
				 }
				 else
				 {
					 request.setAttribute("errorMessage1", "Wrong credentials!");
					 RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
					 requestDispatcher.forward(request, response);		
				 }
			 }
			 else
			 {
				 request.setAttribute("errorMessage2", "Please select client or agent!");
				 RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
				 requestDispatcher.forward(request, response);		 
			 }
				 
		 }
		 
	 }

}
