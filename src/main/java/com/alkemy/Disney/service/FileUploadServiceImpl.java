package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.repository.ImageRepository;
import com.alkemy.Disney.service.abstraction.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class FileUploadServiceImpl implements FileUploadService{

    private final ImageRepository imageRepository;
    @Override
    public Image uploadImageToDB(MultipartFile image) {
        if(image != null){           
            try {               
              return 
                imageRepository.save( Image.builder()
                        .fileData(image.getBytes())
                        .fileType(image.getContentType())
                        .name_image(image.getOriginalFilename())
                        .build());               
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else{
            return null;
        }
    }


  
    
}
