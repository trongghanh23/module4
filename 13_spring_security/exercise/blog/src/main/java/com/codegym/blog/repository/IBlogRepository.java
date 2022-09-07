package com.codegym.blog.repository;


import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Iterable<Blog> findAllByCategory(Category category);

    @Query(value = " select * from blog where title like :searchValue ", nativeQuery = true,
            countQuery = " select count(*) from (select * from blog where title like :searchValue ) temp_table ")
    Page<Blog> getAllBlog(@Param("searchValue") String searchValue, Pageable pageable);
}