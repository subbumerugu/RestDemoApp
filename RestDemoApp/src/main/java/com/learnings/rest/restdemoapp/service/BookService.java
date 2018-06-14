package com.learnings.rest.restdemoapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learnings.rest.restdemoapp.model.Book;

public class BookService {
	private Map<Long,Book> books = new HashMap<Long, Book>();
	
	public BookService() {
		 for (Long i=1L; i<=10; i++) {
			 Book m = new Book(i,"Book Title - "+i, "Subbu-"+i);
			 books.put(i, m);
			 
		 }
	}
	
	public List<Book> getBooks(){
		return new ArrayList<Book> (books.values());
	}
	public Book getBook(Long id) {
		return books.get(id);
	}
}
