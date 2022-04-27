package com.alkemy.Disney.repository.especifications;

import com.alkemy.Disney.model.Entity.CharacterFilm;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.request.FilterRequest;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import org.springframework.util.StringUtils;

@Component
public class CharacterSpecification {
   
    public Specification<CharacterFilm> getFiltered(FilterRequest charFilters){
		
		// LAMBDA Function:
		return (root, query, criteriaBuilder) -> {
			
			List<Predicate> predicates = new ArrayList<>();
			
			// == Name ==
			// IF hay algo en la String:
			// 	predicates.add(
			//		Buildeamos un SQL LIKE -> (Database Table, aComparar) --> ejemplo: (name, valorDTO)
			// 	)
			if(StringUtils.hasLength(charFilters.getName_character())) {
				predicates.add(
						criteriaBuilder.like(
							criteriaBuilder.lower(root.get("name_character")),
							"%" + charFilters.getName_character().toLowerCase() + "%"
						)
				);
			}
			
			// == Age ==
			// Casteo a STR
			// IF Hay algo -> Comparar "age" con el INT pasado en DTO.
			if(charFilters.getAge() != null) {
				predicates.add(
						criteriaBuilder.equal(root.get("age"), charFilters.getAge()								)
						);
			}
			
			// == CharMovies ==
			// IF Not Empty
			//	JOIN ("characters" type INNER) con movieID ("id"). Una vez unido Agregamos JOIN = LO QUE SE AGREGA
			// 	ADD -> los movieId iguales al DTO enviado, dentro de mi tabla conjunta.
			// En Criollo:
			//		Pegamos las tablas (Character y Movie) (Hibernate se encarga de encontrarlas
			//								a partir de las entidades)
			//		Tomamos el ID de movie, para cada una de las relaciones existentes, y lo guardamos (moviesID)
			//		Add -> si dicho moviesID, coincide con el del DTO Filtrado.
			if(!CollectionUtils.isEmpty(charFilters.getMovies())) {
				Join<CharacterFilm, Movie> join = root.join("movies", JoinType.INNER);
				Expression<String> moviesId = join.get("id");				
				predicates.add(moviesId.in(charFilters.getMovies()));				
			}			
			
			// Removemos Duplicados:
			query.distinct(true);
			// Damos un orden HARD CODEADO: ASC por NAME
			query.orderBy(criteriaBuilder.asc(root.get("name_character")));
			
			// MAIN RETURN:
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			
		};
	}
}
