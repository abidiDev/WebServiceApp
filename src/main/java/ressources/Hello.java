package ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class Hello {
	public Hello() {
	}
	//ressource 1
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response sayHello() {
		return Response.status(200).entity("hello").build();
	}
	//ressource accessible with queryParam
	@Path("hello2")
	@GET()
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello2(@QueryParam(value = "FirstName") String prenom, @QueryParam(value = "LastName")String nom) {
		
		return Response.status(200).entity("hello"+nom+""+prenom).build();	
		}
	//ressource accessible with pathParam
	@Path("hello3/{FirstName}/{LastName}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello3(@PathParam(value="FirstName") String nom,@PathParam(value="LastName") String prenom) {
		return Response.status(200).entity("hello"+" "+nom+" "+prenom).build();
	}
}
