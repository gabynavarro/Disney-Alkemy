package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.ListMovieResponse;
import com.alkemy.Disney.model.response.MovieResponse;
import java.util.List;
import java.util.Set;


public interface MovieService {
    MovieResponse save(MovieRequest request, Image image);
    List<ListMovieResponse> findAll();
    MovieResponse findById(Long id);
    void deleted(Long id);
    void update(Long id,MovieRequest request,Image image);
    List<ListMovieResponse> getByFilters(String name, Set<Long> genre, String order);
}
