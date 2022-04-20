package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.IImage;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ImageService {
    ResponseEntity<Resource> generateImage(IImage image);
  
}
