package rest;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloService {
	
	// url: /rest/hello/now
	@Path("/now")
	@GET
	@Produces("text/plain")
	public String time() {
		return new Date().toString();
	}
	
	// url: /rest/hello/lotto/1
	// url: /rest/hello/lotto/5
	@Path("/lotto/{num}")
	@GET
	@Produces("application/json")
	public List<Integer> lotto(@PathParam("num") Integer num) {
		Random r = new Random();
		List<Integer> lottos = new LinkedList<>();
		for(int i=0; i<num;i++) {
			lottos.add(r.nextInt(100));
		}
		return lottos;
	}
	
	// url: /rest/hello/lucky?num=1
	// url: /rest/hello/lucky?num=5
	@Path("/lucky")
	@GET
	@Produces("application/json")
	public List<Integer> lucky(@DefaultValue("0") @QueryParam("num") Integer num) {
		Random r = new Random();
		List<Integer> lottos = new LinkedList<>();
		for(int i=0; i<num;i++) {
			lottos.add(r.nextInt(100));
		}
		return lottos;
	}
	
	
}
