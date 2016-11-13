package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class SqlHelper {


	    public Connection connection ;
	    
	    public static final String SQL_URL="jdbc:mysql://114.115.221.211:3306/test1";
	    public static final String USERNAME="nju";
	    public static final String PASSWORD="admin@12345";
	    
	    private static SqlHelper instance;
	    public void init() {
	        try {
	             //����һ��MYSQL���Ӷ���
	            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL����
	            connection = DriverManager.getConnection(SQL_URL, USERNAME, PASSWORD); //���ӱ���MYSQL
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

//		public static void main(String[] args) throws SQLException {
//			SqlHelper sqlHelper=new SqlHelper();

//			if(sqlHelper.login("admin", "admin")==1){
//				System.out.println("Login Succcess");
//			};
			
//			if(sqlHelper.register("test", "test")!=0){
//				System.out.println("Register Success");
//			}

//		}
		
	
		
}


