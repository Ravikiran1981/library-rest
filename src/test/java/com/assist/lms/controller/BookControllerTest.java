package com.assist.lms.controller;

import com.assist.lms.dto.BookDTO;
import com.assist.lms.dto.CreateBookRequest;
import com.assist.lms.model.Author;
import com.assist.lms.model.Book;
import com.assist.lms.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllBooks() throws Exception {
        Author author = new Author();
        author.setName("Kiran");
        author.setId(1L);
        CreateBookRequest request = new CreateBookRequest();
        request.setTitle("Pride and Prejudice");
        request.setIsbn("111-222-333");
        request.setAuthorId(1L);

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Pride and Prejudice");
        book.setIsbn("111-222-333");
        book.setAuthor(author);
        
        Mockito.when(bookService.createBook(Mockito.anyLong(), Mockito.any(Book.class)))
        .thenReturn(book);

        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.title").value("Pride and Prejudice"))
               .andExpect(jsonPath("$.authorName").value("Kiran"));

    }

}

