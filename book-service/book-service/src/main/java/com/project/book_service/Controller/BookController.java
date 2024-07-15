package com.project.book_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.book_service.Entity.Book;
import com.project.book_service.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService service;

	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return service.addBook(book);
	}

	@GetMapping("getbyid")
	public Book getBookById(@RequestHeader int id) {
		return service.getBookById(id);
	}

	@GetMapping("getallbooks")
	public List<Book> getAllBook() {
		return service.getAllBook();
	}

	@GetMapping("getbyauthorid")
	public List<Book> getAllBookByAuthorid(@RequestHeader int authorId) {
		return service.getAllBookByAuthorid(authorId);
	}
}
