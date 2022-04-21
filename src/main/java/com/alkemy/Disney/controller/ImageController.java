package com.alkemy.Disney.controller;

import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.repository.ImageRepository;
import com.alkemy.Disney.service.abstraction.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/images")
public class ImageController {
    private final ImageService imageService;
    private final ImageRepository imageRepository;

    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> findImageById(@PathVariable(name = "id") String id){
        Image image =  imageRepository.findById(id).get();
        return imageService.generateImage(image);
    }


}
