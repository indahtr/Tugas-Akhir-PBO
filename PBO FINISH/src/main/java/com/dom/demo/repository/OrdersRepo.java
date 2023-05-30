package com.dom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dom.demo.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer>{
    
}
