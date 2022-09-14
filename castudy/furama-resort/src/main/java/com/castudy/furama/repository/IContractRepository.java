package com.castudy.furama.repository;

import com.castudy.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where customer like :nameFind or facility like :nameFind", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable, @Param("nameFind") String nameFind);

    Page<Contract> findAllByEndDayContaining(String endDay, Pageable pageable);
}