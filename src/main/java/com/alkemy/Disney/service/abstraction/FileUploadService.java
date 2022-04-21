package com.alkemy.Disney.service.abstraction;


import com.alkemy.Disney.model.Entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    public Image uploadImageProfileToDB(MultipartFile image);  

}
