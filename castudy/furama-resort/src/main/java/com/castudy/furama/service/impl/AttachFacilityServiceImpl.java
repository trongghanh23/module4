package com.castudy.furama.service.impl;


import com.castudy.furama.model.AttachFacility;
import com.castudy.furama.repository.AttachFacilityRepository;
import com.castudy.furama.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttachFacilityServiceImpl implements IAttachFacilityService {
    @Autowired
    private AttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}