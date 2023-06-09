package com.dom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dom.demo.model.Addresses;

@Repository
public interface AddressesRepo extends JpaRepository<Addresses, Integer>{
    
}
