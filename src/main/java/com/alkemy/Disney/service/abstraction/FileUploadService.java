package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.ImageProfile;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    public ImageProfile uploadImageProfileToDB(MultipartFile image);  

}
