package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.sun.corba.se.impl.naming.pcosnaming.NameServer;

import bl.RiskManager;
import bl.UserManager;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserManager userManager;
	RiskManager riskManager;
	
	@Override
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		userManager=new UserManager();
		int result = userManager.login(user, password);
		if(result==0){
			request.setAttribute("message", "0");
			request.getRequestDispatcher("Login.jsp").forward(request,response);
		}else{
			riskManager=new RiskManager();
			ArrayList<String> names = riskManager.queryProjectNames();
			request.setAttribute("names", names);
			request.getRequestDispatcher("ProjectRisks.jsp").forward(request,response);
		}
	}
}
