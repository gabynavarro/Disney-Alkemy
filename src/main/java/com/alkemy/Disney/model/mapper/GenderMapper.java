package com.alkemy.Disney.model.mapper;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.request.GenderRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import org.springframework.stereotype.Component;

@Component
public class GenderMapper {
    
    
    public Gender toGender(GenderRequest request){
        return Gender.builder()
                .name_gender(request.getName_gender())
                .image_gender(request.getImage_gender())                
                .movies(null)                
                .build();      
        
    }
    public GenderResponse genderToResponse(Gender gender){
         String url="http://localhost:8080/api/v1/images/image/";
        ModelImage image=ModelImage.builder()
                .idImage(gender.getImage_gender().getId())
                .imageName(gender.getImage_gender().getName_image())
                .urlImage(url+gender.getImage_gender().getId())
                .build();
        return GenderResponse.builder()
                .id(gender.getId())              
                .name_gender(gender.getName_gender())
                .deleted(gender.isDeleted())
                .image(image)
                .build();        
    }
}
