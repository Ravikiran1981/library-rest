package com.assist.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assist.lms.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByAuthorId(Long authorId);
}