package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlHelper {


	    public Connection connection ;
	    
	    public static final String SQL_URL="jdbc:mysql://127.0.0.1:3306/pm";
	    public static final String USERNAME="root";
	    public static final String PASSWORD="root";
	    
	    private static SqlHelper instance;
	    public void init() {
	        try {
	             //定义一个MYSQL链接对象
	            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
	            connection = DriverManager.getConnection(SQL_URL, USERNAME, PASSWORD); //链接本地MYSQL
	            System.out.println("MySQL is connected ");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    private SqlHelper() {
			// TODO Auto-generated constructor stub
	    	init();
		}
	    
	    public static SqlHelper getInstance() {
			if(instance==null){
				instance=new SqlHelper();
			}
			return instance;
		}

		public Connection getConnection() {
			return connection;
		}

		public static void main(String[] args) throws SQLException {
//			SqlHelper sqlHelper=new SqlHelper();

//			if(sqlHelper.login("admin", "admin")==1){
//				System.out.println("Login Succcess");
//			};
			
//			if(sqlHelper.register("test", "test")!=0){
//				System.out.println("Register Success");
//			}

		}
		
	
		
}


