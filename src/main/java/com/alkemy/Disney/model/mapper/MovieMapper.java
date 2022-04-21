package com.alkemy.Disney.model.mapper;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.MovieResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    
    @Autowired
    private ImageMapper imageMapper;
    
    public Movie movieDTO2Entity(MovieRequest request, List<Gender> gender){
       return  Movie.builder()
               .title(request.getTitle())
               .date_created(request.getDate_created())
               .genders(gender)
               .Character(null)
               .calificated(request.getCalificated())
               .image_movie(request.getImage_movie())               
               .build();
        
    }
    public MovieResponse movieDTO2Entity(Movie entity){
       return  MovieResponse.builder()
               .id(entity.getId())
               .title(entity.getTitle())
               .date_created(entity.getDate_created())
              // .gender_movie(entity.getGenders().get(0))
               .Character(null)
               .calificated(entity.getCalificated())
               .image_movie(imageMapper.imageEntity2ModelImage(entity.getImage_movie()))               
               .build();
        
    }
}
