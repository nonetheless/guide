package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.RiskManager;
import dao.RiskDAO;

@WebServlet("/ProjectRisk")
public class ProjectRiskServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RiskManager riskManager;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		riskManager = new RiskManager();
		ArrayList<RiskDAO> risks = riskManager.queryRiskDAO(name);
		PrintWriter out = response.getWriter();
		out.print(risks);
	}

}
