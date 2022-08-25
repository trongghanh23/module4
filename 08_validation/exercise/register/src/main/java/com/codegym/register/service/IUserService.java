package com.codegym.register.service;

import com.codegym.register.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
