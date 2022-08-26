package com.codegym.manage_library.repository;

import com.codegym.manage_library.model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrafficRepository  extends JpaRepository<Traffic, Integer> {
}
