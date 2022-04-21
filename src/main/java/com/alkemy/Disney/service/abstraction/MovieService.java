package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.MovieResponse;
import java.util.List;


public interface MovieService {
    MovieResponse save(MovieRequest request, Image image);
    List<MovieResponse> findAll();
}