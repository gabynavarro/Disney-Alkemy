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
//                .image_gender(request.getImage_gender())
                .movies(null)                
                .build();      
        
    }
    public GenderResponse GenderToResponse(Gender gender){
        return GenderResponse.builder()
                .id(gender.getId())
//                .image_gender(gender.getImage_gender().getName_image())
                .name_gender(gender.getName_gender())
                .build();        
    }
}
