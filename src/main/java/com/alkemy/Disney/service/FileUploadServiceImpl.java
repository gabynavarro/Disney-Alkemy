package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.ImageProfile;
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
    public ImageProfile uploadImageProfileToDB(MultipartFile image) {
        if(image != null){
            ImageProfile profileImage = new ImageProfile();
            try {
                profileImage.setFileData(image.getBytes());
                profileImage.setFileType(image.getContentType());
                profileImage.setName_image(image.getOriginalFilename());
                imageRepository.save(profileImage);
                return profileImage;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else{
            return null;
        }
    }

   
    
}
