package ressources;

import java.security.PublicKey;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import javassist.LoaderClassPath;

@ApplicationPath("Rest")

public class RestActivator  extends Application {
	public RestActivator() {

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8090");
		beanConfig.setBasePath("helloWebService/Rest");
		beanConfig.setResourcePackage("ressources");
		beanConfig.setPrettyPrint(true);
		beanConfig.setScan(true);
		beanConfig.setSchemes(new String[]{"http"});
		}
	@Override
	public Set<Class<?>> getClasses() {
	Set<Class<?>> resources = new HashSet();

	resources.add(EmployeeApi.class);
	resources.add(EtudiantApi.class);

	resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
	resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
	return resources;	
}
}
