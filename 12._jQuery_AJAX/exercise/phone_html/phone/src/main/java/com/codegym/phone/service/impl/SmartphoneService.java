package com.codegym.phone.service.impl;


import com.codegym.phone.model.Smartphone;
import com.codegym.phone.repository.ISmartphoneRepository;
import com.codegym.phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;


    @Override
    public Page<Smartphone> findAllPage(Pageable pageable) {
        return iSmartphoneRepository.findAllPage(pageable);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return iSmartphoneRepository.save(smartphone);
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return iSmartphoneRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iSmartphoneRepository.deleteById(id);
    }
}