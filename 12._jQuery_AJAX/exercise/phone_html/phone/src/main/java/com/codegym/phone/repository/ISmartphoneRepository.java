package com.codegym.phone.repository;


import com.codegym.phone.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {

    @Query(value = " select * from smartphones ", nativeQuery = true)
    Page<Smartphone> findAllPage(Pageable pageable);
}