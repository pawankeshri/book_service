package com.pk.demo.services.book_service.service;

// mvn package -Dmaven.test.skip=true 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.demo.services.book_service.entity.Book;
import com.pk.demo.services.book_service.exception.RecordNotFoundException;
import com.pk.demo.services.book_service.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> bookList = bookRepository.findAll();

		if (bookList.size() > 0) {
			return bookList;
		} else {
			return new ArrayList<Book>();
		}
	}

	public Book getBookById(Long id) throws RecordNotFoundException {
		Optional<Book> employee = bookRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No book found for given id");
		}
	}

	public Book createOrUpdateBook(Book entity) throws RecordNotFoundException {
		Optional<Book> book = bookRepository.findById(entity.getId());

		if (book.isPresent()) {
			Book newEntity = book.get();
			newEntity.setAuthor(entity.getAuthor());
			newEntity.setLanguage(entity.getLanguage());
			newEntity.setNumOfPages(entity.getNumOfPages());
			newEntity.setTitle(entity.getTitle());
			newEntity.setType(entity.getType());

			newEntity = bookRepository.save(newEntity);
			return newEntity;
		} else {
			entity = bookRepository.save(entity);

			return entity;
		}
	}

	public void deleteBookById(Long id) throws RecordNotFoundException {
		Optional<Book> employee = bookRepository.findById(id);

		if (employee.isPresent()) {
			bookRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No book found for given id");
		}
	}
}