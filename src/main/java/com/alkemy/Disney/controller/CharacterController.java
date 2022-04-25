package com.alkemy.Disney.controller;

import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.response.CharacterDetails;
import com.alkemy.Disney.model.response.CharacterResponse;
import com.alkemy.Disney.service.abstraction.CharacterFilmService;
import com.alkemy.Disney.service.abstraction.FileUploadService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1/character")
@RequiredArgsConstructor
@CrossOrigin("*")
@Api(value = "Character method of movies and series", description = "This API has a character the Movie")
public class CharacterController {
    
    @Autowired
    private CharacterFilmService characterService;
    @Autowired
    private FileUploadService fileUploadService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterResponse create(@Valid @RequestPart(value = "character", required = true) CharacterRequest request,
             @RequestPart(value = "image", required = false) MultipartFile image)             
            throws URISyntaxException{
        
        return characterService.save(request, fileUploadService .uploadImageProfileToDB(image));
    }
    @GetMapping("/characters")
    public List<CharacterResponse> getAllChatacter(){
        return characterService.getAllCharacters();
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        characterService.delete(id);
    }
    
    @GetMapping("/{id}")    
    public CharacterDetails getById(@PathVariable Long id){
        return characterService.findById(id);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @Valid @RequestPart(value = "character", required = true) CharacterRequest request)                        
            throws URISyntaxException{
        characterService.update(id, request);
    }
}
