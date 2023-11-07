package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author abel
 * @create 2023-09-17 8:27
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"完美世界","114514",new BigDecimal(9999),1000,1000,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(7);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(6,"好吃的蛋炒饭","abel",new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(15);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for(Book book:books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println( bookDao.queryForPageTotalCount() );
    }

    @Test
    public void queryForPageItems() {
        for(Book book:bookDao.queryForPageItems(19, Page.PAGE_SIZE)){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        Integer integer = bookDao.queryForPageTotalCountByPrice(10, 100);
        System.out.println(integer);
    }

    @Test
    public void queryForPageItemsByPrice() {
        for(Book book:bookDao.queryForPageItemsByPrice(0,Page.PAGE_SIZE,10,50)){
            System.out.println(book);
        }
    }
}