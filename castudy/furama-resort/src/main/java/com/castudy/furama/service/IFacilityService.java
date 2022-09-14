package com.castudy.furama.service;



import com.castudy.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    Page<Facility> findAllSearchAndPaging(String nameFacility, Pageable pageable);

    void save(Facility facility);

    Facility getId(Integer id);

    void delete(Integer id);

    List<Facility> findAll();


}
