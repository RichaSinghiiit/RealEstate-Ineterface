package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import DAO.AgentDAO;
import Models.AgentModel;

/**
 * Servlet implementation class AgentDashboardServlet
 */
@WebServlet("/AgentDashboard")
public class AgentDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AgentDashboardServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		 int agent_id = (int)session.getAttribute("userID");
		 out.println(agent_id);
		 try{
		 AgentDAO dao = new AgentDAO();
		 AgentModel agent = dao.getDetails(agent_id);
		 
		 request.setAttribute("agent", agent);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 RequestDispatcher reqDispatcher = request.getRequestDispatcher("AgentDashboard.jsp");
		 reqDispatcher.forward(request,response);
	}

}
