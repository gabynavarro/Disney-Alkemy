
package com.alkemy.Disney.repository;

import com.alkemy.Disney.model.Entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long>{
    
}
