package com.dom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dom.demo.model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>{
    
}
