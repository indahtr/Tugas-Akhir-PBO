package com.dom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dom.demo.model.Orderdetail;

@Repository
public interface OrderdetailRepo extends JpaRepository<Orderdetail, Integer>{
    
}
