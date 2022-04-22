package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.mapper.GenderMapper;
import com.alkemy.Disney.model.mapper.MovieMapper;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import com.alkemy.Disney.model.response.MovieResponse;
import com.alkemy.Disney.repository.GenderRepository;
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
    private GenderRepository genderRepository;
    @Override
    public MovieResponse save(MovieRequest request, Image image) {
        request.setImage_movie(image);
        List<Gender> list=new ArrayList<>();
        List<Movie> newMovie=new ArrayList<>();
         Movie entitySaved = movieRepository.save(movieMapper.movieDTO2Entity(request, list));
           
        newMovie.add(entitySaved);
        System.out.println("LLEGA PRIMERO");
        for (int i = 0; i < request.getGender_movie().size(); i++) {
            System.out.println("LLEGA SEGUNDO");
            Gender g=new Gender();
             g=genderService.finById(request.getGender_movie().get(i).getId());            
            list.add(g);
            System.out.println("LLEGA ACA ");
            newMovie.add(entitySaved);
            g.setMovies(newMovie);
            genderRepository.save(g);
        }
        entitySaved.setGenders(list);
        movieRepository.save(entitySaved);
      
        return  movieMapper.movieDTO2Entity(entitySaved);
    }

    @Override
    public List<MovieResponse> findAll() {
        
        return null;
    }

}
