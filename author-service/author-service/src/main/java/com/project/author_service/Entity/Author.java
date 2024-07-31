package com.project.author_service.Entity;

import java.util.List;

import com.project.author_service.Dto.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorid;
	private String name;
	private String email;
	private String phno;
	@Transient
	private List<Book> books;
	@Transient
	private String message;

}
