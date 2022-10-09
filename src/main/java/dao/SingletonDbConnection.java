package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class SingletonDbConnection {
	// connecting to the data base
	private static Connection connection;


	 
	 public static Connection getConnection() {

		   try {
		        Class.forName("com.mysql.jdbc.Driver");
				connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/webservicedb","root", "");

		        
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return connection;
		 }
}