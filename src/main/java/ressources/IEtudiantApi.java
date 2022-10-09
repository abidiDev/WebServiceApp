package ressources;

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

import entities.Etudiant;

public interface IEtudiantApi {
	public Response getEtuduants();
	
    public Response filterEtuduants(String f);
	
	public Response addEtudiant(Etudiant E);

    public Response deleteEtuduants(String cin);
	
	public Response updateEtudiant(Etudiant E);

}
