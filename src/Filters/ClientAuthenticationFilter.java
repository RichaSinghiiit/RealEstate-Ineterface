package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
/**
 * Servlet Filter implementation class ClientAuthenticationFilter
 */
@WebFilter(urlPatterns = {"/InterestedProperties","/deleteProperties", "/userProfile.jsp", "/userProfile"})
public class ClientAuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ClientAuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

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
		
		

		if(!session.getAttribute("user").equals("client"))
		{
			req.setAttribute("errorMessage1", "Access Denied!");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(req, response);
		}
		
		
		// pass the request along the filter chain
		else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
