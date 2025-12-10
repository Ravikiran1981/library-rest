package com.assist.lms.dto;

public class CreateAuthorRequest {
	  private String name;

	  public CreateAuthorRequest() {}

	  public CreateAuthorRequest(String name) { this.name = name; }

	  public String getName() { return name; }
	  public void setName(String name) { this.name = name; }
	}