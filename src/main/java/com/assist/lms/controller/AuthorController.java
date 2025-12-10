package com.assist.lms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assist.lms.dto.CreateAuthorRequest;
import com.assist.lms.model.Author;
import com.assist.lms.service.AuthorService;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @PostMapping
  public ResponseEntity<Author> createAuthor(@RequestBody CreateAuthorRequest req) {
    Author author = new Author(req.getName());
    Author created = authorService.createAuthor(author);
    return ResponseEntity.created(URI.create("/api/authors/" + created.getId())).body(created);
  }

  @GetMapping
  public List<Author> listAuthors() {
    return authorService.listAuthors();
  }

  @GetMapping("/{id}")
  public Author getAuthor(@PathVariable Long id) {
    return authorService.getAuthor(id);
  }

  @GetMapping("/{id}/books")
  public ResponseEntity<?> getBooksByAuthor(@PathVariable Long id) {
    return ResponseEntity.status(307).header("Location", "/api/books?authorId=" + id).build();
  }
}
