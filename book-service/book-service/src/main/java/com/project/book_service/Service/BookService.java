package com.project.book_service.Service;

import java.util.List;

import com.project.book_service.Entity.Book;

public interface BookService {

	public Book addBook(Book book);
	public Book getBookById(int id);
	public List<Book> getAllBook();
	public List<Book> getAllBookByAuthorid(int authorId);
}
