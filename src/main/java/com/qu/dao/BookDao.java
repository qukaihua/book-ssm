package com.qu.dao;

import com.qu.bean.Book;
import com.qu.bean.BookSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 96283 on 2018/11/8.
 */
public interface BookDao {
    public void insertBook(@Param("book")Book book);
    public void deleteBook(@Param("id")int id);
    public List<Book> getBooks(@Param("booksearch")BookSearch bookSearch);
    public void update(@Param("book")Book book);
}
