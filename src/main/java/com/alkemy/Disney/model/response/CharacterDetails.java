
package com.alkemy.Disney.model.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Builder @AllArgsConstructor
@NoArgsConstructor

public class CharacterDetails {
    private Long id;
    protected boolean deleted;
    private String name_character;
    private int age;    
    private double weight;
    private String history;     
    private List <ModelMovie> movies;       
    private ModelImage image_character;
}
