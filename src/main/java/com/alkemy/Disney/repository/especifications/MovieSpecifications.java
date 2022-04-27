package com.alkemy.Disney.repository.especifications;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.request.MovieFiltersRequest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
public class MovieSpecifications {

    public Specification<Movie> getFiltered(MovieFiltersRequest movieFilters) {

        // Lambda Function:
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // == Name ==
            if (StringUtils.hasLength(movieFilters.getTitle())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + movieFilters.getTitle().toLowerCase() + "%"
                        )
                );
            }

            // == Genre ==
            if (!CollectionUtils.isEmpty(movieFilters.getGenre()) ){
                Join<Movie, Gender> join = root.join("genders", JoinType.INNER);
                Expression<String> genresId = join.get("id");
                predicates.add(genresId.in(movieFilters.getGenre()));
            }

            query.distinct(true);

            // == Order ==
            String orderByField = "title";
            query.orderBy(
                    movieFilters.isASC()
                    ? criteriaBuilder.asc(root.get(orderByField))
                    : criteriaBuilder.desc(root.get(orderByField))
            );

            // MAIN RETURN:
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
