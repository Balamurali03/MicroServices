package com.project.book_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.project.book_service.Entity.Book;
import com.project.book_service.Service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;

	public Book addBook(Book book) {
		return service.addBook(book);
	}

	public Book getBookById(int id) {
		return service.getBookById(id);
	}

	public List<Book> getAllBook() {
		return service.getAllBook();
	}

	public List<Book> getAllBookByAuthorid(int authorId) {
		return service.getAllBookByAuthorid(authorId);
	}
}
