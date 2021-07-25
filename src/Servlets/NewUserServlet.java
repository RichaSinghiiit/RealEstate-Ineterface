package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NewUserDAO;

@WebServlet("/newUserServlet")

public class NewUserServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	 {
		String user = request.getParameter("user");
		String name = request.getParameter("name");
		long contact_number = Long.parseLong(request.getParameter("number"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		
		NewUserDAO dao = new NewUserDAO();
		int duplicate = dao.addUser(user, name,contact_number, email, password, address);
		
		if(duplicate == -1)
		{
			request.setAttribute("errorMessage", "Account with this Email ID already exists!");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("NewUser.jsp");
			 requestDispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("Login.jsp");
		}
		
	}
}
