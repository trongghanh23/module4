package com.castudy.furama.repository;

import com.castudy.furama.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
//    List<ContractDetail> findAllByContract_IdContract(Integer id);
}