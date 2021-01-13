package com.demo.service.impl;

import com.demo.entity.Book;
import com.demo.mapper.BookMapper;
import com.demo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookMapper  bookMapper ;

	@Override
	public Book getById(long bookId) {
		return bookMapper.queryById(bookId);
	}

	@Override
	public List<Book> getList() {
		return bookMapper.queryAll();
	}

}
