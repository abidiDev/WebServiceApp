package ressources;

import javax.ws.rs.core.Response;

import entities.Employee;

public interface IEmployeeApi {
	
    public Response getEmployees();
	
    public Response filterEmployees(String f);
	
	public Response addEmployee(Employee E);

    public Response deleteEmployees(String cin);
	
	public Response updateEmployee(Employee E);
}
