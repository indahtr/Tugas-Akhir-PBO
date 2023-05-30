package com.dom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dom.demo.model.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer>{
    
}