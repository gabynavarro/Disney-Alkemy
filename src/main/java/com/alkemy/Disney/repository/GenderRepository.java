
package com.disney.disney.repository;

import com.alkemy.Disney.model.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long>{
    
}
