package com.alkemy.Disney.controller;

import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.request.MovieRequest;
import com.alkemy.Disney.model.response.CharacterResponse;
import com.alkemy.Disney.model.response.MovieResponse;
import com.alkemy.Disney.service.abstraction.CharacterFilmService;
import com.alkemy.Disney.service.abstraction.FileUploadService;
import com.alkemy.Disney.service.abstraction.MovieService;
import io.swagger.annotations.Api;
import java.net.URISyntaxException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
