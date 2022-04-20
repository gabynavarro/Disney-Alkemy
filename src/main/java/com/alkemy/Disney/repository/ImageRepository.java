package com.alkemy.Disney.repository;

import com.alkemy.Disney.model.Entity.IImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<IImage,String>{
    
}
