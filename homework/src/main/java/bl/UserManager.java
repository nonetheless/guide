package bl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.SqlHelper;

public class UserManager {

	private Connection connection;
	
	public UserManager() {
		// TODO Auto-generated constructor stub
		SqlHelper sqlHelper=SqlHelper.getInstance();
		connection=sqlHelper.getConnection();
				
	}
	
	public int login(String userName,String password) {
		int result=0;
		
		try {
			String sql="select * from user where username = ? and password = ?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet resultSet=statement.executeQuery();
			if(resultSet.next()){
				result=resultSet.getInt(1);
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int register(String userName,String password) {
		int result=0;
		String sql="insert into user(username,password) values(?,?)";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, password);
			result=statement.executeUpdate();
			
			if(result!=0){
				sql="select * from user where username = ? and password = ?";
				statement=connection.prepareStatement(sql);
				statement.setString(1, userName);
				statement.setString(2, password);
				ResultSet resultSet=statement.executeQuery();
				if(resultSet.next()){
					result=resultSet.getInt(1);
				};
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
