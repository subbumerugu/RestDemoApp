package com.learnings.rest.restdemoapp.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	public List<Book> getBooks(){
		return bookService.getBooks();
	}
	
	@GET
	@Path("{bookId}")
	public Book getBook(@PathParam("bookId") Long id) {
		return bookService.getBook(id);
		
	}
}
