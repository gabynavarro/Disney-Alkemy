
package com.disney.disney.model;

import com.disney.disney.model.BaseClass;
import io.swagger.annotations.ApiModel;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel("Model Character")
@Builder
public class Character extends  BaseClass{
        
    @NotBlank
    @Size(min = 10, max = 20, message = "Name Character must be between 10 and 20 characters long")  
    private String name_character;
    private int age;
    private double weight;
    private String history;
    
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    private List <Movie> associated_movies;
    
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})   
    private Image imageProfile;
    

}
