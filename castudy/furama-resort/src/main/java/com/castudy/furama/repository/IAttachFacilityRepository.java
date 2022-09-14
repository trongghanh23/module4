package com.castudy.furama.repository;


import com.castudy.furama.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
//    AttachFacility findAllByContractDetails_IdContractDetail(Integer id);
}