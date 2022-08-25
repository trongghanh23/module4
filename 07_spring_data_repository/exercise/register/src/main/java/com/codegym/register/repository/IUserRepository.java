package com.codegym.register.repository;

import com.codegym.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface IUserRepository extends JpaRepository<User,Integer> {
}
