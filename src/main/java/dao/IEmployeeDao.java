package dao;

import java.util.List;

import entities.Employee;

public interface IEmployeeDao {
	public List<Employee> get();
	public List<Employee> filter(String f);
	public List<Employee> add( Employee E);
	public List<Employee> update(Employee E);
	public List<Employee> delete(String cin);


}
