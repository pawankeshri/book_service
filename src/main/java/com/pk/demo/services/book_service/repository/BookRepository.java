package com.pk.demo.services.book_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.demo.services.book_service.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}