package com.assist.lms.service;

import org.springframework.stereotype.Service;

import com.assist.lms.exception.NotFoundException;
import com.assist.lms.model.Author;
import com.assist.lms.repository.AuthorRepository;


import java.util.List;

@Service
public class AuthorService {
  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author createAuthor(Author author) {
    return authorRepository.save(author);
  }

  public List<Author> listAuthors() {
    return authorRepository.findAll();
  }

  public Author getAuthor(Long id) {
    return authorRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Author not found with id " + id));
  }
}

