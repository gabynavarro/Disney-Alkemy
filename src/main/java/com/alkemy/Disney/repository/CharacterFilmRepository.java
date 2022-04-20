package com.alkemy.Disney.repository;

import com.alkemy.Disney.model.Entity.CharacterFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterFilmRepository extends JpaRepository<CharacterFilm, Long> {
    
}
