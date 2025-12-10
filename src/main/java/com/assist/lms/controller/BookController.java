package com.assist.lms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assist.lms.dto.BookDTO;
import com.assist.lms.dto.CreateBookRequest;
import com.assist.lms.model.Book;
import com.assist.lms.service.BookService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  // Create a book by specifying authorId in payload

  @PostMapping
  public ResponseEntity<BookDTO> createBook(@RequestBody CreateBookRequest request) {
      Book created = bookService.createBook(request.getAuthorId(),
                                            new Book(request.getTitle(), request.getIsbn()));
      BookDTO dto = new BookDTO(created.getId(), created.getTitle(), created.getIsbn(), created.getAuthor().getName());
      return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }
  
  // List all books or optionally filter by authorId query param
	@GetMapping
	public List<BookDTO> listBooks(@RequestParam(required = false) Long authorId) {
		List<Book> books;

		if (authorId != null) {
			books = bookService.listBooksByAuthor(authorId);
		} else {
			books = bookService.listBooks();
		}

		return books.stream()
				.map(book -> new BookDTO(book.getId(), book.getTitle(), book.getIsbn(), book.getAuthor().getName()))
				.toList();
	}
	
  @GetMapping("/{id}")
  public Book getBook(@PathVariable Long id) {
    return bookService.getBook(id);
  }
}
