package com.codegym.blog.repository;


import com.codegym.blog.entity.AppUser;
import com.codegym.blog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
   List<UserRole>  findByAppUser (AppUser appUser);
}
