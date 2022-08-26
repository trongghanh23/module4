package com.codegym.manage_library.service;

import com.codegym.manage_library.model.Library;

import java.util.List;

public interface ILibraryService {
    List<Library> findAll();

    void save(Library library);

    void borrowBook(Integer id);

    void setQuantity(Integer id);
}
