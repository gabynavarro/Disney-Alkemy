package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.mapper.GenderMapper;
import com.alkemy.Disney.model.mapper.MovieMapper;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.MovieResponse;
import com.alkemy.Disney.model.response.ResponseGenderMovie;
import com.alkemy.Disney.repository.MovieRepository;
import com.alkemy.Disney.service.abstraction.GenderService;
import com.alkemy.Disney.service.abstraction.MovieService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private GenderService genderService;
    @Autowired
    private GenderMapper genderMapper;

    @Override
    public MovieResponse save(MovieRequest request, Image image) {
        request.setImage_movie(image);
        List<Gender> list = new ArrayList<>();
        List<ResponseGenderMovie> resGenderMovie = new ArrayList<>();
        Movie entitySaved = movieMapper.movieDTO2Entity(request, list);
        for (int i = 0; i < request.getGender_movie().size(); i++) {
            Gender g = genderService.finById(request.getGender_movie().get(i).getId());
            list.add(g);
            entitySaved.setGenders(list);
            resGenderMovie.add(genderMapper.genderToGenderMovie(g));
            movieRepository.save(entitySaved);
        }

        return movieMapper.movieDTO2Entity(entitySaved, resGenderMovie);
    }

    @Override
    public List<MovieResponse> findAll() {
        List<Movie> m = movieRepository.findAll();
        List<MovieResponse> response = new ArrayList<>();
        for (Movie movie : m) {
            response.add(movieMapper.movieDTO2Entity(movie, generateList(movie.getGenders())));
        }

        return response;
    }

    public List<ResponseGenderMovie> generateList(List<Gender> genders) {
        List<ResponseGenderMovie> listGenders = new ArrayList<>();
        for (Gender gender : genders) {
            listGenders.add(genderMapper.genderToGenderMovie(gender));
        }
        return listGenders;
    }

    @Override
    public MovieResponse findById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        return movieMapper.movieDTO2Entity(movie, generateList(movie.getGenders()));
    }

    @Override
    public void deleted(Long id) {
        Movie movie = movieRepository.getById(id);
        movie.setDeleted(true);
        movieRepository.save(movie);
    }

    @Override
    public void update(Long id,MovieRequest request, Image image) {
        request.setImage_movie(image);
        List<Gender> listGender = new ArrayList<>();     
         Movie movieUpdate=movieRepository.findById(id).orElseThrow();
         movieUpdate = movieMapper.updateDTO2Entity(movieUpdate,request, listGender);     
        for (int i = 0; i < request.getGender_movie().size(); i++) { 
            Gender g = genderService.finById(request.getGender_movie().get(i).getId());
            listGender.add(g);
            movieUpdate.setGenders(listGender);          
            movieRepository.save(movieUpdate);
        }
    }
    
}
