package com.demo.mapper;

import com.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

	/**
	 * 通过ID查询单本图书
	 *
	 * @param id
	 * @return
	 */
	Book queryById(@Param("bookId") long id);

	/**
	 * 查询所有图书
	 * @return
	 */
	List<Book> queryAll();

	List<Book> queryAllByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

}
