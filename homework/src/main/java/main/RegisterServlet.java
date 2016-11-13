package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import bl.UserManager;

public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserManager userManager;
	
	@Override
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		userManager=new UserManager();
		int result = userManager.register(user, password);
		if(result==1){
            //HttpSession session=request.getSession(true);  
            //session.putValue("user", user);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

}
