package com.project.author_service.Service;

import java.util.List;

import com.project.author_service.Entity.Author;

public interface AuthorService {

	public Author saveAuthor(Author author);
	public Author getAuthorById(int id);
	public List<Author> getAllAuthor();
	public Author getAuthorAndBookByAuthorId(int id);
	public List<Author> getAllAuthorAndBookByAuthorId();
}
