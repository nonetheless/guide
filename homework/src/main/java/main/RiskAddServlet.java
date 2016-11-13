package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.RiskManager;
import dao.RiskDAO;

/**
 * Servlet implementation class RiskAddServlet
 */
@WebServlet("/RiskAdd")
public class RiskAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RiskAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("riskAdd.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectName = request.getParameter("projectName");
		String riskContent = request.getParameter("riskContent");
		Integer riskTrigger = Integer.parseInt(request.getParameter("riskTrigger"));
		String riskPos = request.getParameter("riskPos");
		String riskAffect = request.getParameter("riskAffect");
		
		RiskDAO risk = new RiskDAO();
		risk.setContent(riskContent);
		risk.setIsEnded(0);
		risk.setProjectName(projectName);
		risk.setPossiblity(riskPos);
		risk.setAffect(riskAffect);
		risk.setThreshold(riskTrigger);		
		
		RiskManager rm = new RiskManager();
		boolean result = rm.createRisk(risk);
		
		PrintWriter out = response.getWriter();
		if(result) {
			out.print("success");
		}else{
			out.print("failure");
		}
	}

}
