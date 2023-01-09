package ressources;

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

import dao.EmployeeDao;
import dao.EtudiantDao;
import dao.IEntityDao;
import dao.StaticEtudiantDao;
import entities.Employee;
import entities.Etudiant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("etudiant")
@Api(tags = "Etudiant")
public class EtudiantApi implements IEtudiantApi  {
	/***couplage faible car on a utilisé les interfaces ****/
	private IEntityDao<Etudiant> dao;
	
	public EtudiantApi() {
		dao=new StaticEtudiantDao();
	};
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "GET all Etudiants")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
    public Response getEtuduants() {
		return Response.status(200).entity(dao.get()).build();	

    }
	
	@Path("/filter/{filter}")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "Filter Etudiants")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
    public Response filterEtuduants(@PathParam(value="filter")String f) {
		return Response.status(200).entity(dao.filter(f)).build();	

    }
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "Add Etudiant")
	@ApiResponses({
		@ApiResponse(code=201 , message="Success")
	})
	public Response addEtudiant(Etudiant E){
		
		
			return Response.status(201).entity(dao.add(E)).build();	

		
	}
	
	@Path("/delete/{cin}")
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "Delete Etudiant")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
    public Response deleteEtuduants(@PathParam(value="cin")String cin) {
		return Response.status(200).entity(dao.delete(cin)).build();	

    }

	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "Update Etudiant")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
	public Response updateEtudiant(Etudiant E){
		
		
			return Response.status(200).entity(dao.update(E)).build();	

		
	}

	

	
}

