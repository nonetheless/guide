package bl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.StatusDAO;
import util.DateFormatHelper;
import util.SqlHelper;

public class StatusManager {

	private Connection connection;
	
	public StatusManager() {
		// TODO Auto-generated constructor stub
		SqlHelper sqlHelper=SqlHelper.getInstance();
		connection=sqlHelper.getConnection();
	}
	
	public boolean addStatus(StatusDAO statusDAO) {
		boolean result=true;
		
		String sql="insert into status(riskId, followerId, description, createTime ) values (?, ?, ?, ?)";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, statusDAO.getRiskId());
			statement.setInt(2, statusDAO.getFollowerId());
			statement.setString(3, statusDAO.getDescription());
			statement.setString(4, DateFormatHelper.getCurrentTime());
			result=(statement.executeUpdate()!=0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<StatusDAO> getStatus(int riskId){
		ArrayList<StatusDAO> statusDAOs=new ArrayList<StatusDAO>();
		String sql="select * from status where riskId= ?";
		
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, riskId);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				StatusDAO statusDAO=new StatusDAO();
				statusDAO.setId(resultSet.getInt(1));
				statusDAO.setRiskId(resultSet.getInt(2));
				statusDAO.setFollowerId(resultSet.getInt(3));
				statusDAO.setDescription(resultSet.getString(4));
				statusDAO.setCreateTime(resultSet.getString(5));
				statusDAOs.add(statusDAO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return statusDAOs;
	}
	
	public static void main(String[] args) {
		StatusManager statusManager=new StatusManager();
		StatusDAO statusDAO=new StatusDAO();
		statusDAO.setFollowerId(1);
		statusDAO.setDescription("Test");
//		if(statusManager.addStatus(statusDAO)){
//			System.out.println("Success");
//		}
//		if(statusManager.getStatus(0).size()==1){
//			System.out.println(statusManager.getStatus(0).get(0).getCreateTime());
//		}
	}
}
