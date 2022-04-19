package com.alkemy.Disney.repository;


import com.alkemy.Disney.model.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String>{
    
}
