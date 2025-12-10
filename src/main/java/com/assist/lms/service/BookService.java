package com.assist.lms.service;

import org.springframework.stereotype.Service;

import com.assist.lms.exception.NotFoundException;
import com.assist.lms.model.Author;
import com.assist.lms.model.Book;
import com.assist.lms.repository.AuthorRepository;
import com.assist.lms.repository.BookRepository;


import java.util.List;

@Service
public class BookService {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  public Book createBook(Long authorId, Book book) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new NotFoundException("Author not found with id " + authorId));
    book.setAuthor(author);
    return bookRepository.save(book);
  }

  public List<Book> listBooks() {
    return bookRepository.findAll();
  }

  public Book getBook(Long id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Book not found with id " + id));
  }

  public List<Book> listBooksByAuthor(Long authorId) {
    // ensure author exists (optional)
    if (!authorRepository.existsById(authorId)) {
      throw new NotFoundException("Author not found with id " + authorId);
    }
    return bookRepository.findByAuthorId(authorId);
  }
}
