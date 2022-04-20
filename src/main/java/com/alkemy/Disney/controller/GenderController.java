package com.alkemy.Disney.controller;

import com.alkemy.Disney.model.request.GenderRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import com.alkemy.Disney.service.abstraction.FileUploadService;
import com.alkemy.Disney.service.abstraction.GenderService;
import io.swagger.annotations.Api;
import java.net.URISyntaxException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/gender")
@CrossOrigin("*")
@RequiredArgsConstructor
@Api(value = "Genre method of movies and series", description = "This API has a Gender the Movie")
public class GenderController {
    
    @Autowired 
    private GenderService genderService;
    @Autowired
    private  FileUploadService fileUploadService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenderResponse create(@Valid @RequestPart(value = "gender", required = true) GenderRequest request,
             @RequestPart(value = "image", required = false) MultipartFile image)            
            throws URISyntaxException{
        
        return genderService.save(request, fileUploadService.uploadImageProfileToDB(image));
    }

    @GetMapping
    public List<GenderResponse> getAllGenders(){
        return genderService.getGenders();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody GenderRequest request){
        genderService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        genderService.delete(id);
    }
}
