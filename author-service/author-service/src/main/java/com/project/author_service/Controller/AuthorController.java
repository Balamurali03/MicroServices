package com.project.author_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.author_service.Client.BookClient;
import com.project.author_service.Dto.Book;
import com.project.author_service.Entity.Author;
import com.project.author_service.Service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService service;
	
	
	
	@PostMapping("/save")
	public Author saveAuthor(@RequestBody Author author) {
		return service.saveAuthor(author);
	}
	@GetMapping("get")
	public Author getAuthorById(@RequestHeader int id) {
		Author author = service.getAuthorById(id);;
		return author;
	}
	@GetMapping("getall")
	public List<Author> getAllAuthor(){
		return service.getAllAuthor();
	}
	@GetMapping("/check")
	public Author check(@RequestHeader int id) {
		return service.getAuthorAndBookByAuthorId(id);
	}
}
