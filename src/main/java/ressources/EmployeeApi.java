package ressources;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.aopalliance.reflect.Code;

import dao.EmployeeDao;
import dao.EmployeeDao;
import dao.IEmployeeDao;
import dao.IEmployeeDao;
import entities.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import entities.Employee;

@Api(tags = "Employee")
@Path("employee")
public class EmployeeApi implements IEmployeeApi {
	/***couplage faible car on a utilisé les interfaces ****/
	private IEmployeeDao dao;
	public EmployeeApi() {
		dao=new EmployeeDao();
	};
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "GET all Employee")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
    public Response getEmployees() {
		return Response.status(200).entity(dao.get()).build();	

    }
	
	@Path("/filter/{filter}")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "Filter Employees")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
    public Response filterEmployees(@PathParam(value="filter")String f) {
		return Response.status(200).entity(dao.filter(f)).build();	

    }
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "Add an Employee")
	@ApiResponses({
		@ApiResponse(code=201 , message="Success")
	})

	public Response addEmployee(Employee E){
		
		
			return Response.status(201).entity(dao.add(E)).build();	

		
	}
	
	@Path("/delete/{cin}")
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "Delete Employee")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
    public Response deleteEmployees(@PathParam(value="cin")String cin) {
		return Response.status(200).entity(dao.delete(cin)).build();	

    }
		
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "update Employee")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
	public Response updateEmployee(Employee E){
		
		
			return Response.status(200).entity(dao.update(E)).build();	

		
	}
	



}
