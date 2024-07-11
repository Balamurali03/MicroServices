package com.project.book_service.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.book_service.Entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

	public Optional<List<Book>> findByAuthorid(int authorId);
}
