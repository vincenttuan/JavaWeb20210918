package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Book;

@Path("/book")
public class BookService {
	
	static List<Book> books;
	static {
		books = new ArrayList<>();
		books.add(new Book(101, "Java"));
		books.add(new Book(102, "Python"));
		books.add(new Book(103, "VB"));
	}
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String create(@FormParam("id") Integer id, 
			             @FormParam("name") String name) {
		books.add(new Book(id, name));
		return new Gson().toJson(books);
	}
	
	@Path("/")
	@GET
	@Produces("application/json")
	public String read() {
		return new Gson().toJson(books);
	}
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String update(@FormParam("id") Integer id, 
            			 @FormParam("name") String name) {
		Optional<Book> opt = books.stream()
								.filter(b -> b.getId() == id)
								.findAny();
		if(opt.isPresent()) {
			Book book = opt.get();
			book.setName(name);
			return new Gson().toJson(books);
		} else {
			return "update error";
		}
	}
	
	@Path("/")
	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String delete(@FormParam("id") Integer id) {
		return "delete book";
	}
	
}
