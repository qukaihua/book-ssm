package com.qu.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.qu.bean.BookSearch;
import com.qu.Service.BookService;
import com.qu.bean.Book;
import com.qu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 96283 on 2018/11/8.
 */
@Service
public class BookServiceImpl implements BookService{
     @Autowired
    BookDao bookDao;

    @Override
    public void insertBook(Book book) {
        bookDao.insertBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public List<Book> getBooks(BookSearch bookSearch,int page,int rows,String sort,String seq) {
         String orderby = ""+seq+" "+sort+"";
         PageHelper.startPage(page,rows,orderby);
         return bookDao.getBooks(bookSearch);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.update(book);
    }
}
