package com.learnings.rest.restdemoapp.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.learnings.rest.restdemoapp.model.Book;
import com.learnings.rest.restdemoapp.service.BookService;

@Path("books")
public class BookResource {

	BookService bookService = new BookService();
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "Books PING Success!!!";
		/*http://localhost:8080/RestDemoApp/messages/ping
*/	
		}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks(){
		List<Book> books = bookService.getBooks(); 
		return Response.status(Status.OK).entity(books).build();
	}
	
	@GET
	@Path("{bookId}")
	public Response getBook(@PathParam("bookId") Long id) {
		Book book = bookService.getBook(id); 
		return Response.status(Status.OK).entity(book).build();
		
	}
}
