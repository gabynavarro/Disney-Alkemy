package com.alkemy.Disney.repository;

import com.alkemy.Disney.model.Entity.Movie;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>,  JpaSpecificationExecutor <Movie> {

    public List<Movie> findAll(Specification<Movie> filtered);
    
}
