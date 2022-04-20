package com.alkemy.Disney.repository;

import com.alkemy.Disney.model.Entity.ImageProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageProfileRepository extends JpaRepository<ImageProfile,String>{
    
}
