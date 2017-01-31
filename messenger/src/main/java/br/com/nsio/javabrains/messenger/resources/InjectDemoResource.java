package br.com.nsio.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderParam") String customHeaderParam,
											@CookieParam("name") String cookieName){
		return "Matrix param : " + matrixParam + " Header Param : " + customHeaderParam;
	}
	
	// The context dont work with any types, like above, where Jersey doing the conversion
	// the context works with special types
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = httpHeaders.getCookies().toString();
		return "Path : " + path + " Cookies : " + cookies;
		
	}
	
	
}
