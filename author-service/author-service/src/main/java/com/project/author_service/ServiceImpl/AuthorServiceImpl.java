package com.project.author_service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.author_service.Client.BookClient;
import com.project.author_service.Dto.Book;
import com.project.author_service.Entity.Author;
import com.project.author_service.Repo.AuthorRepo;
import com.project.author_service.Service.AuthorService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepo repo;
	
	@Autowired
	private BookClient bookClient;

	@Override
	public Author saveAuthor(Author author) {
		
		return repo.save(author);
	}

	@Override
	public Author getAuthorById(int id) {
		if(repo.existsById(id)) {
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public List<Author> getAllAuthor() {
		
		List<Author> getAllAuthor=repo.findAll();
		if(! getAllAuthor.isEmpty()) {
			return getAllAuthor;
		}
		return null;
	}

	@Override
	@CircuitBreaker(name="BookClient", fallbackMethod ="getFallBack" )
	public Author getAuthorAndBookByAuthorId(int id) {
		if(repo.existsById(id)) {
			 Author author = repo.findById(id).orElse(null);
			 if(author != null) {
				 List<Book> allBookByAuthorid = bookClient.getAllBookByAuthorid(id);
				 author.setBooks(allBookByAuthorid);
				 author.setMessage("Books attached to author");
			 }
			 
			 return author;
		}
		
		return null;
	}

	@Override
	public List<Author> getAllAuthorAndBookByAuthorId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Author getFallBack(int id, Throwable throwable) {
		 Author author = repo.findById(id).orElse(null);
	        if (author != null) {
	            author.setBooks(List.of());
	            author.setMessage("Due to high traffic Book Service cannot be accessiable at the moment");
	        }
	        return author;
		
	}

}
