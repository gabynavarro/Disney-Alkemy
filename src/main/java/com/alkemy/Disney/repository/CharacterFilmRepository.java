package com.alkemy.Disney.repository;

import com.alkemy.Disney.model.Entity.CharacterFilm;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterFilmRepository extends JpaRepository<CharacterFilm, Long>,JpaSpecificationExecutor<CharacterFilm>  {
    // For Filtering:
	List<CharacterFilm> findAll(Specification<CharacterFilm> specs);
}
