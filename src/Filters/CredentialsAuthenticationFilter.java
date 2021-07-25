package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CredentialsAuthenticationFilter
 */
@WebFilter("/CredentialsAuthenticationFilter")
public class CredentialsAuthenticationFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		String path = req.getRequestURI();
		if (path.endsWith("/Login.jsp") || path.endsWith("/loginServlet") || path.endsWith("/newUserServlet") || path.endsWith("/NewUser.jsp") || path.endsWith("/search.jsp") || path.endsWith("/result")) {
		    chain.doFilter(request, response);// Just continue chain
		}
		else
		{
			if(session.getAttribute("userID")== null)
			{
				req.setAttribute("errorMessage1", "Login required!");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
				requestDispatcher.forward(req, response);
			}
		
		
			// pass the request along the filter chain
			else
				chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
