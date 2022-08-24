package com.manager_blog.repository;

import com.manager_blog.model.Blogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IBlogRepository extends JpaRepository<Blogger, Integer> {


    @Query(value = " select * from blogger where name like :searchName ", nativeQuery = true,
            countQuery = " select count(*) from (select * from blogger where name like :searchName ) temp_table ")
    Page<Blogger> getAllBlog(@Param("searchName") String searchName , Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = " delete from blogger b where b.id = :id ", nativeQuery = true)
    void deleteBlog(@Param("id") int id);

    @Query(value = " select * from blogger b where b.id = :id", nativeQuery = true)
    Blogger getBlogger(@Param("id") int id);



}