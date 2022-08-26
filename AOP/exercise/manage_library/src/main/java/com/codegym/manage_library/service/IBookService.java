package com.codegym.manage_library.service;

import com.codegym.manage_library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void setStatus(Integer id);

    void returnBook(Integer bookCode) throws Exception;

}
