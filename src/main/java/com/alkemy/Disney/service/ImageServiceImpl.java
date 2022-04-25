package com.alkemy.Disney.service;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.repository.ImageRepository;
import com.alkemy.Disney.service.abstraction.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{
    private final ImageRepository imageRepository;

    @Override
    public ResponseEntity<Resource> generateImage(Image image) {
        return ResponseEntity.ok()
               .contentType(MediaType.parseMediaType(image.getFileType()))
               .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename = " + image.getName_image())
               .body(new ByteArrayResource(image.getFileData()));
    }

    private void deleteImage(Image image){imageRepository.delete(image);}    
}
