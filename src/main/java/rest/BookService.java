package rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/book")
public class BookService {
	
	@Path("/")
	@POST
	public String create() {
		return "create book";
	}
	
	@Path("/")
	@GET
	public String read() {
		return "read book";
	}
	
	@Path("/")
	@PUT
	public String update() {
		return "update book";
	}
	
	@Path("/")
	@DELETE
	public String delete() {
		return "delete book";
	}
	
}
