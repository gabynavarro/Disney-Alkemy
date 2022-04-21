package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.mapper.GenderMapper;
import com.alkemy.Disney.model.mapper.MovieMapper;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import com.alkemy.Disney.model.response.MovieResponse;
import com.alkemy.Disney.repository.MovieRepository;
import com.alkemy.Disney.service.abstraction.GenderService;
import com.alkemy.Disney.service.abstraction.MovieService;
import java.util.ArrayList;
import java.util.List;
import javax.management.loading.PrivateClassLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
    
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
        List<Gender> list=new ArrayList<>();
        Gender gender= genderMapper.reponseToGender(genderService.getGender(request.getGender_movie()));
        list.add(gender);
        Movie entitySaved = movieRepository.save(movieMapper.movieDTO2Entity(request, list));
        
        return  movieMapper.movieDTO2Entity(entitySaved);
    }

    @Override
    public List<MovieResponse> findAll() {
        
        return null;
    }

}
