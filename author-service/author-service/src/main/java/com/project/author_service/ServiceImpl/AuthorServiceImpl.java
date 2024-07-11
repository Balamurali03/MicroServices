package com.project.author_service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.author_service.Entity.Author;
import com.project.author_service.Repo.AuthorRepo;
import com.project.author_service.Service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepo repo;

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

}
