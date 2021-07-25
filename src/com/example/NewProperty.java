package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewProperty
 */
@WebServlet("/NewProperty")
public class NewProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProperty() {
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
		String property_for=request.getParameter("property_for");
		int asking_price=Integer.parseInt(request.getParameter("asking_price"));
		int size=Integer.parseInt(request.getParameter("size"));
		int house_number=Integer.parseInt(request.getParameter("house_number"));
		String locality=request.getParameter("locality");
		String property_type=request.getParameter("property_type");
		int number_of_bedrooms=Integer.parseInt(request.getParameter("number_of_bedrooms"));
		int number_of_bathrooms=Integer.parseInt(request.getParameter("number_of_bathrooms"));
		String new_or_resale =request.getParameter("new_or_resale");
		String construction_status=request.getParameter("construction_status");
		String furnishing=request.getParameter("furnishing");
		int parking=Integer.parseInt(request.getParameter("parking"));
		String booking_status=request.getParameter("booking_status");
	    
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact_number=request.getParameter("contact_number");
		String address=request.getParameter("address");
		
		HttpSession session = request.getSession();
		int agent_id = (int)session.getAttribute("userID");
		property prop=new property( property_for,property_type,  locality,  new_or_resale,
			construction_status,  furnishing,  booking_status,asking_price, house_number,
			size,  number_of_bedrooms,  number_of_bathrooms,  parking);
		
		owner owns= new owner( name,  email,  address, contact_number);
		NewPropertyDao newDao= new NewPropertyDao();
		String result=newDao.insert(prop,owns,agent_id);
		
		response.getWriter().println(result);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("AgentDashboard");
		reqDispatcher.forward(request,response);
		
		//doGet(request, response);
	}

}
