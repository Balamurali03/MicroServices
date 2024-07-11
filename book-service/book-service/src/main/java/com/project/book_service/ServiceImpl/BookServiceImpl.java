package com.project.book_service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.book_service.Entity.Book;
import com.project.book_service.Repo.BookRepo;
import com.project.book_service.Service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo repo;

	@Override
	public Book addBook(Book book) {

		return repo.save(book);
	}

	@Override
	public Book getBookById(int id) {

		if(repo.existsById(id)) {
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public List<Book> getAllBook() {

		List<Book> getAllBook=repo.findAll();
		if(! getAllBook.isEmpty()) {
			return getAllBook;
		}
		return null;
	}

	@Override
	public List<Book> getAllBookByAuthorid(int authorId) {

		List<Book> getAllBookByAuthorid=repo.findByAuthorid(authorId).get();
		if(! getAllBookByAuthorid.isEmpty()) {
			return getAllBookByAuthorid;
		}
		return null;
	}

}
