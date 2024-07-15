package com.project.author_service.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.author_service.Dto.Book;



@FeignClient(name="book-service",url="localhost:8322")
public interface BookClient {

	@GetMapping("book/getbyauthorid")
	public List<Book> getAllBookByAuthorid(@RequestHeader int authorId);
	
	
}
