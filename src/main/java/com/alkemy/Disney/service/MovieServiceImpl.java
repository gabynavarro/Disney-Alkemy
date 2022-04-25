package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.CharacterFilm;
import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.mapper.CharacterMapper;
import com.alkemy.Disney.model.mapper.GenderMapper;
import com.alkemy.Disney.model.mapper.MovieMapper;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.ListMovieResponse;
import com.alkemy.Disney.model.response.MovieResponse;
import com.alkemy.Disney.model.response.ReponseCharMovie;
import com.alkemy.Disney.model.response.ResponseGenderMovie;
import com.alkemy.Disney.repository.CharacterFilmRepository;
import com.alkemy.Disney.repository.MovieRepository;
import com.alkemy.Disney.service.abstraction.GenderService;
import com.alkemy.Disney.service.abstraction.MovieService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
    @Autowired
    private CharacterFilmRepository characterFilmRepository;
    @Autowired
    private CharacterMapper characterMapper;
    
    @Override
    public MovieResponse save(MovieRequest request, Image image) {
        request.setImage_movie(image);
        List<Gender> listGenders = new ArrayList<>();
        List<ResponseGenderMovie> resGenderMovie = new ArrayList<>();
        List<ReponseCharMovie> charMovies=new ArrayList<>();
        List<CharacterFilm> characters=new ArrayList<>();
        
        Movie entitySaved = movieMapper.movieDTO2Entity(request, listGenders ,characters);
        for (int i = 0; i < request.getGender_movie().size(); i++) {
            Gender g = genderService.finById(request.getGender_movie().get(i).getId());
            listGenders.add(g);
            entitySaved.setGenders(listGenders);
            resGenderMovie.add(genderMapper.genderToGenderMovie(g));
            movieRepository.save(entitySaved);
        }
         for (int i = 0; i < request.getCharacters().size(); i++) {
            CharacterFilm c = characterFilmRepository.getById(request.getCharacters().get(i).getId());
            characters.add(c);            
            entitySaved.setCharacters(characters);            
            charMovies.add(characterMapper.generateToCharacterMovie(c));
            movieRepository.save(entitySaved);
        }

        return movieMapper.movieDTO2Entity(entitySaved, resGenderMovie,charMovies );
    }

    @Override
    public List<ListMovieResponse> findAll() {
     return movieRepository.findAll().stream()
                .map( i -> movieMapper.listMovieDTO2(i) )
                .collect(Collectors.toList());
    }

    public List<ResponseGenderMovie> generateListGender(List<Gender> genders) {
        List<ResponseGenderMovie> listGenders = new ArrayList<>();
        for (Gender gender : genders) {
            listGenders.add(genderMapper.genderToGenderMovie(gender));
        }
        return listGenders;
    }
    
     public List<ReponseCharMovie> generateListCharacter(List<CharacterFilm> characters) {
        List<ReponseCharMovie> listChatacter = new ArrayList<>();
        for (CharacterFilm chart : characters) {
            listChatacter.add(characterMapper.generateToCharacterMovie(chart));
        }
        return listChatacter;
    }

    @Override
    public MovieResponse findById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        return movieMapper.movieDTO2Entity(movie, generateListGender(movie.getGenders()),generateListCharacter(movie.getCharacters()));
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
