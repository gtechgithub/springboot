package com.javapoint;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface BookService {

	Book save (Book book);
	void delete (Book book);
	Book findOne(String id);
	
	Iterable <Book> findall();
    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);
}
