package com.assist.lms.dto;


public class BookDTO {

    private Long id;
    private String title;
    private String isbn;
    private String authorName;

    public BookDTO() {}

    public BookDTO(Long id, String title, String isbn, String authorName) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.authorName = authorName;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
