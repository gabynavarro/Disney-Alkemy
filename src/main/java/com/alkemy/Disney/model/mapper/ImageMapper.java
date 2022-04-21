package com.alkemy.Disney.model.mapper;



import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.response.ModelImage;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ModelImage imageEntity2ModelImage(Image entity) {
        String url="http://localhost:8080/api/v1/images/image/";
        return ModelImage.builder()
                .idImage(entity.getId())
                .imageName(entity.getName_image())
                .urlImage(url+entity.getId())
                .build();
        
    }
}
