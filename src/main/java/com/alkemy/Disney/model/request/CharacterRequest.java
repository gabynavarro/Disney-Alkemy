package com.alkemy.Disney.model.request;

import com.alkemy.Disney.model.Entity.Image;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class CharacterRequest {
    
    @NotEmpty(message = " El nombre del personaje no puede estar vacía ")
    private String name_character;
    @NotNull (message = "La edad no puede estar vacío")
    @Range (max = 1000, min = 1, message = "El rango de edad debe estar entre 1-1000.")
    private int age;
    @NotNull (message = "El peso no puede estar vacío")
    private double weight;
    @NotEmpty (message = "Historia del personaje no puede estar vacía ")
    private String history;
    
    private Long id_Movie; //associated movies
  
    private Image image_character;
    
 
  
}
