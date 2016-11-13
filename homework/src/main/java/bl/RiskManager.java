package bl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.RiskDAO;
import util.DateFormatHelper;
import util.SqlHelper;

public class RiskManager {

	private Connection connection;
	
	public RiskManager() {
		// TODO Auto-generated constructor stub
		SqlHelper sqlHelper=SqlHelper.getInstance();
		connection=sqlHelper.getConnection();
	}
	
	public boolean createRisk(RiskDAO riskDAO){
		boolean result=true;
		
		String sql="insert into risk( possiblity, affect, threshold, submitterId, fowllerId, createTime, endTime, projectName, isEnded, content) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, riskDAO.getPossiblity());
			statement.setString(2, riskDAO.getAffect());
			statement.setInt(3, riskDAO.getThreshold());
			statement.setInt(4, riskDAO.getSubmitterId());
			statement.setInt(5, riskDAO.getFollowerId());
			statement.setString(6, DateFormatHelper.getCurrentTime());
			statement.setString(7, riskDAO.getEndTime());
			statement.setString(8, riskDAO.getProjectName());
			statement.setInt(9, riskDAO.getIsEnded());
			statement.setString(10, riskDAO.getContent());
			result=(statement.executeUpdate()!=0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<String> queryProjectNames() {
		ArrayList<String> result=new ArrayList<String>();
		
		String sql="select distinct projectName from risk";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()){
				result.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<RiskDAO> queryRiskDAO(String projectName) {
		ArrayList<RiskDAO> result=new ArrayList<RiskDAO>();
		String sql="select * from risk where projectName = ?";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, projectName);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				RiskDAO riskDAO=new RiskDAO();
				riskDAO.setId(resultSet.getInt(1));
				riskDAO.setPossiblity(resultSet.getString(2));
				riskDAO.setAffect(resultSet.getString(3));
				riskDAO.setThreshold(resultSet.getInt(4));
				riskDAO.setSubmitterId(resultSet.getInt(5));
				riskDAO.setFollowerId(resultSet.getInt(6));
				riskDAO.setCreateTime(resultSet.getString(7));
				riskDAO.setEndTime(resultSet.getString(8));
				riskDAO.setProjectName(resultSet.getString(9));
				//riskDAO.setIsEnded(resultSet.getInt(10));
				riskDAO.setContent(resultSet.getString(11));
				result.add(riskDAO);
			};
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updateRiskDAO(RiskDAO riskDAO) {
		boolean result=true;
		
		String sql="UPDATE risk SET possiblity=?, affect=?, threshold=?, submitterId=?, fowllerId=?,  endTime=?, projectName=?, isEnded=?, content=? WHERE id=?;";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, riskDAO.getPossiblity());
			statement.setString(2, riskDAO.getAffect());
			statement.setInt(3, riskDAO.getThreshold());
			statement.setInt(4, riskDAO.getSubmitterId());
			statement.setInt(5, riskDAO.getFollowerId());
			statement.setString(6, riskDAO.getEndTime());
			statement.setString(7, riskDAO.getProjectName());
			statement.setInt(8, riskDAO.getIsEnded());
			statement.setString(9, riskDAO.getContent());
			statement.setInt(10, riskDAO.getId());
			result=(statement.executeUpdate()!=0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		RiskDAO riskDAO=new RiskDAO();
		riskDAO.setId(1);
		riskDAO.setContent("TestUpdate");
		riskDAO.setProjectName("Homework");
		RiskManager riskManager=new RiskManager();
//		if(riskManager.queryRiskDAO("homework").size()==1){
//			System.out.println("Success");
//		}
//		
//		if(riskManager.queryProjectNames().size()==1){
//			System.out.println(riskManager.queryProjectNames().get(0));
//		}
		
		if(riskManager.updateRiskDAO(riskDAO)){
			System.out.println("Success");
		}
	}
}
