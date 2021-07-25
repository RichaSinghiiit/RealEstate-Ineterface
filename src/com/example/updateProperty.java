package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Servlet implementation class updateProperty
 */
@WebServlet("/update")
public class updateProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProperty() {
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
		
		int property_id= Integer.parseInt(request.getParameter("property_id"));
		int agent_id= Integer.parseInt(request.getParameter("agent_id"));
		int client_id= Integer.parseInt(request.getParameter("client_id"));
		int booking_price= Integer.parseInt(request.getParameter("booking_price"));
		String first_date=(request.getParameter("first_date"));
		String last_date=(request.getParameter("last_date"));
		
		booking booked = new booking( property_id,  client_id,agent_id,  booking_price,  first_date,
			last_date);
		UpdatePropertyDao newDao= new UpdatePropertyDao();
		String result=newDao.insert(booked);
		
		//response.getWriter().println(result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("AgentDashboard");
		requestDispatcher.forward(request, response);	
		
	}

}
