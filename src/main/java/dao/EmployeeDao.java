package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;
import entities.Employee;
import entities.Employee;

public class EmployeeDao implements IEmployeeDao {
	
	private static Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	String query;
	
	public EmployeeDao() {

		EmployeeDao.connection= SingletonDbConnection.getConnection();

	}
	@Override
	public List<Employee> get() {
		List<Employee> employeeList=new ArrayList<Employee>();

		
		  try {
			ps=connection.prepareStatement("SELECT * from employee");
			  rs=ps.executeQuery();
			  while(rs.next()) {
				   Employee e = new Employee();      
				   e.setCin(rs.getString("cin"));
				   e.setFirstName(rs.getString("firstName"));
				   e.setLastName(rs.getString("lastName"));
				  
				  employeeList.add(e);
				} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  return employeeList;
	}

	@Override
	public List<Employee> filter(String f) {
		List<Employee> employeeList=new ArrayList<Employee>();

		
		  try {
			ps=connection.prepareStatement("SELECT * from employee WHERE cin LIKE  ? OR firstName LIKE ? OR lastName LIKE ?  ");
			ps.setString(1, '%'+f+'%');
			ps.setString(2, '%'+f+'%');
			ps.setString(3, '%'+f+'%');
		
			  rs=ps.executeQuery();
			  while(rs.next()) {
				  Employee e = new Employee();      
				   e.setCin(rs.getString("cin"));
				   e.setFirstName(rs.getString("firstName"));
				   e.setLastName(rs.getString("lastName"));
				  employeeList.add(e);
				} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  return employeeList;
	}

	@Override
	public List<Employee> add(Employee E) {
		
		 try {
				ps=connection.prepareStatement("INSERT INTO employee (id,cin, firstName, lastName) VALUES (NULL,?, ?, ?)");
				ps.setString(1,E.getCin());
				ps.setString(2,E.getFirstName());
				ps.setString(3,E.getLastName());

				int add=ps.executeUpdate();
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			  return get();
	}

	@Override
	public List<Employee> update(Employee E) {
		try {
			ps=connection.prepareStatement("UPDATE employee SET firstName=?,lastName=? WHERE cin=?");
			ps.setString(1,E.getFirstName());
			ps.setString(2,E.getLastName());
			ps.setString(3,E.getCin());

		
			int add=ps.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  return get();
    	
    

	}

	@Override
	public List<Employee> delete(String cin) {
		try {
			ps=connection.prepareStatement("DELETE from employee WHERE cin=?");
			ps.setString(1, cin);
		
			int add=ps.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  return get();
	}

}
