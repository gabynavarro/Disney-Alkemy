package com.alkemy.Disney.model.mapper;

import com.alkemy.Disney.model.response.ModelImage;
import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.request.GenderRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import com.alkemy.Disney.model.response.ResponseGenderMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenderMapper {
    
    @Autowired
    private ImageMapper imageMapper;
    
    public Gender toGender(GenderRequest request){
        return Gender.builder()
                .name_gender(request.getName_gender())
                .image_gender(request.getImage_gender())                
                .movies(null)                
                .build();      
        
    }
    public GenderResponse genderToResponse(Gender gender){
        
        return GenderResponse.builder()
                .id(gender.getId())              
                .name_gender(gender.getName_gender())
                .deleted(gender.isDeleted())
                .image(imageMapper.imageEntity2ModelImage(gender.getImage_gender()))
                .build();        
    }
    public ResponseGenderMovie genderToGenderMovie(Gender g) {
        return ResponseGenderMovie.builder()
                .id(g.getId())
                .name_gender(g.getName_gender())
                .build();
    }
}
