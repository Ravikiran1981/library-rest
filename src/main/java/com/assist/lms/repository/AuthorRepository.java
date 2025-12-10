package com.assist.lms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.assist.lms.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Long> {
}

