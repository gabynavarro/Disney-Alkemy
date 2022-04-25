package com.alkemy.Disney.model.mapper;

import com.alkemy.Disney.model.Entity.CharacterFilm;
import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.ListMovieResponse;
import com.alkemy.Disney.model.response.ModelMovie;
import com.alkemy.Disney.model.response.MovieResponse;
import com.alkemy.Disney.model.response.ReponseCharMovie;
import com.alkemy.Disney.model.response.ResponseGenderMovie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Autowired
    private ImageMapper imageMapper;

    public Movie movieDTO2Entity(MovieRequest request, List<Gender> gender, List<CharacterFilm> characters) {
        return Movie.builder()
                .title(request.getTitle())
                .date_created(request.getDate_created())
                .genders(gender)
                .characters(characters)
                .calificated(request.getCalificated())
                .image_movie(request.getImage_movie())
                .build();
    }

    public MovieResponse movieDTO2Entity(Movie entity, List<ResponseGenderMovie> resGender, List<ReponseCharMovie> characters) {
        return MovieResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .date_created(entity.getDate_created())
                .gender_movie(resGender)
                .Character(characters)
                .calificated(entity.getCalificated())
                .image_movie(imageMapper.imageEntity2ModelImage(entity.getImage_movie()))
                .build();
    }

    public Movie updateDTO2Entity(Movie movieUpdate, MovieRequest request, List<Gender> listGender) {
        movieUpdate.setTitle(request.getTitle());
        movieUpdate.setCalificated(request.getCalificated());
        movieUpdate.setImage_movie(request.getImage_movie());
        movieUpdate.setDate_created(request.getDate_created());
        movieUpdate.setCharacters(null);
        movieUpdate.setGenders(listGender);
        return movieUpdate;
    }

    public ModelMovie toModelMovie(Movie movie) {
        return ModelMovie.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .date_created(movie.getDate_created())
                .build();
    }
    
     public ListMovieResponse listMovieDTO2(Movie entity) {
        return ListMovieResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle()) 
                .date_created(entity.getDate_created())
                .image_movie(imageMapper.imageEntity2ModelImage(entity.getImage_movie()))
                .build();
    }
}
