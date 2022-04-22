package com.alkemy.Disney.model.response;

import com.alkemy.Disney.model.Entity.CharacterFilm;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class MovieResponse {
    private Long id;  
    private String title;   
    private LocalDate date_created;  
    private int calificated; //del 1-5 
    private ModelImage image_movie;    
    private List<ResponseGenderMovie> gender_movie;    
    private List<CharacterFilm> Character;
}
