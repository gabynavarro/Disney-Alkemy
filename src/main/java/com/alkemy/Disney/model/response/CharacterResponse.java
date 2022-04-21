package com.alkemy.Disney.model.response;

import com.alkemy.Disney.model.Entity.Movie;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class CharacterResponse {
    private Long id;
    protected boolean deleted; 
    private String name_character;
    private int age;
    private double weight;
    private String history;    
 
    private List <Movie> associated_movies;    
   
    private ModelImage image_character;
}
