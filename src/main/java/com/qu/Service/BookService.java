package com.qu.Service;

import com.qu.bean.BookSearch;
import com.qu.bean.Book;

import java.util.List;

/**
 * Created by 96283 on 2018/11/8.
 */
public interface BookService {
    public void insertBook(Book book);
    public void deleteBook(int id);
    public void updateBook(Book book);
    public List<Book> getBooks(BookSearch bookSearch,int page,int rows,String sort,String seq);
}
