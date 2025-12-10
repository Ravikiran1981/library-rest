package com.assist.lms.dto;

public class CreateBookRequest {
	  private String title;
	  private String isbn;
	  private Long authorId; 

	  public CreateBookRequest() {}

	  public String getTitle() { return title; }
	  public void setTitle(String title) { this.title = title; }

	  public String getIsbn() { return isbn; }
	  public void setIsbn(String isbn) { this.isbn = isbn; }

	  public Long getAuthorId() { return authorId; }
	  public void setAuthorId(Long authorId) { this.authorId = authorId; }
	}