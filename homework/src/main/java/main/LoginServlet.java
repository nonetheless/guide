package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bl.RiskManager;
import bl.UserManager;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserManager userManager;
	RiskManager riskManager;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("names", names);
			request.getRequestDispatcher("ProjectRisks.jsp").forward(request,response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
