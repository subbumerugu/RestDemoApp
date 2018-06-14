package com.learnings.rest.restdemoapp.resource;

import java.util.List;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;

import com.learnings.rest.restdemoapp.model.Book;
import com.learnings.rest.restdemoapp.service.BookService;

@Path("books")
public class BookResource {

	@Inject
	Logger logger;
	@Inject
	BookService bookService;// = new BookService();
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		logger.info("Books Ping");
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{bookId}")
	public Response getBook(@PathParam("bookId") Long id) {
		Book book = bookService.getBook(id);
		return Response.status(Status.OK).entity(book).build();
		
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{bookId}")
	public Response deleteBook(@PathParam("bookId") Long id) {
		Book b = bookService.deleteBook(id);
		return Response.status(Status.OK).entity(b).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(Book book) {
		Book b = bookService.addBook(book);
		return Response.status(Status.CREATED).entity(b).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{bookId}")
	public Response updateBook(@PathParam("bookId") Long id, Book book) {
		book.setId(id);
		Book b = bookService.updateBook(book);
		return Response.status(Status.OK).entity(b).build();
	}
	
	@GET
	@Path("/params/{pathParam}")
	@Produces(MediaType.TEXT_PLAIN)
	public String testParams(@PathParam("pathParam") String pathParam) {
		return "Path Param "+pathParam;
	}
	
	@GET
	@Path("/params")
	@Produces(MediaType.TEXT_PLAIN)
	public String testQueryParms(@QueryParam("bookId") Long id,
			@QueryParam("title") String title,
			@QueryParam("author") String author) {
		return "Query Params for [BookId,Title,Author] = ["+id+","+title+","+author+"]";
	}
}
