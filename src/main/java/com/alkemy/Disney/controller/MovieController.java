package com.alkemy.Disney.controller;

import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.ListMovieResponse;
import com.alkemy.Disney.model.response.MovieResponse;
import com.alkemy.Disney.service.abstraction.FileUploadService;
import com.alkemy.Disney.service.abstraction.MovieService;
import io.swagger.annotations.Api;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/movie")
@CrossOrigin("*")
@RequiredArgsConstructor
@Api(value = "Movie method and series", description = "This API has Movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private FileUploadService fileUploadService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponse create(@Valid @RequestPart(value = "movie", required = true) MovieRequest request,
             @RequestPart(value = "image", required = false) MultipartFile image)             
            throws URISyntaxException{        
        return movieService.save(request, fileUploadService .uploadImageProfileToDB(image));
    }
    @GetMapping("/movies")
    public List<ListMovieResponse> getAllMovies(){
        return movieService.findAll();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        movieService.deleted(id);
    }
    
    @GetMapping("/{id}")    
    public MovieResponse getById(@PathVariable Long id){
        return movieService.findById(id);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @Valid @RequestPart(value = "movie", required = true) MovieRequest request,
             @RequestPart(value = "image", required = false) MultipartFile image)             
            throws URISyntaxException{
        movieService.update(id, request, fileUploadService .uploadImageProfileToDB(image));
    }

    @GetMapping("/filter")
	public List<ListMovieResponse> getDetailsByFilters(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) Set<Long> genre,
			@RequestParam(required = false, defaultValue = "ASC") String order
			){
		
		return movieService.getByFilters(title, genre, order);
	}

}
