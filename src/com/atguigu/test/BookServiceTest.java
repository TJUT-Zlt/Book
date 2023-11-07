package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServeiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author abel
 * @create 2023-09-17 8:38
 */
public class BookServiceTest {

    private BookService bookService = new BookServeiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"神器在手，天下我有！", "1125", new BigDecimal(1000000), 100000000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(6,"啥也不说了,喝酒", "1125", new BigDecimal(1000000), 100000000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(6));
    }

    @Test
    public void queryBooks() {
        for(Book book:bookService.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50 ));
    }
}