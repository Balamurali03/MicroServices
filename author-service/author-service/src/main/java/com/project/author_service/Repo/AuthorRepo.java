package com.project.author_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.author_service.Entity.Author;

public interface AuthorRepo extends JpaRepository<Author,Integer> {

}
