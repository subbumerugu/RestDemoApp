package com.learnings.rest.restdemoapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;

import com.learnings.rest.restdemoapp.model.Book;


@ApplicationScoped
public class BookService {
	//@Inject
	//Logger logger;
	private Map<Long,Book> books = new HashMap<Long, Book>();
	
	public BookService() {
		//logger.info("Book Service - Constructor Logger");
		System.out.println("Book Service Constructor");
		 for (Long i=1L; i<=10; i++) {
			 Book m = new Book(i,"Book Title - "+i, "Subbu-"+i);
			 books.put(i, m);
			 
		 }
	}
	
	public List<Book> getBooks(){
		System.out.println("Book Service - Get Books");
		return new ArrayList<Book> (books.values());
	}
	public Book getBook(Long id) {
		System.out.println("Book Service - Get Book for id"+id );
		Book b = books.get(id);
/*		if (b != null) 
				logger.info(b.getAuthor());
		else
			logger.info("GetBook - No Object Found");
*/		return b;
	}
}
