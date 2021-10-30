package rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloService {
	
	@Path("/now")
	@GET
	@Produces("text/plain")
	public String time() {
		return new Date().toString();
	}
	
}
