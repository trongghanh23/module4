package com.codegym.manage_library.repository;

import com.codegym.manage_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Transactional
    @Query(value = " UPDATE book SET status = 1 WHERE (id = :bookID); ", nativeQuery = true)
    void setStatus(@Param("bookID") int bookID);

    @Query(value = " SELECT * FROM book where (book_code = :bookCode); ", nativeQuery = true)
    Book getByBookCode(@Param("bookCode") Integer bookCode);

    @Modifying
    @Transactional
    @Query(value = " UPDATE book SET status = 0 WHERE (id = :id); ", nativeQuery = true)
    void updateStatus(@Param("id") Integer id);
}
