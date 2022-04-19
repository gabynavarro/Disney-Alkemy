
package com.alkemy.Disney.model.Entity;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class CharacterFilm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected boolean deleted;    
    @NotBlank
    @Size(min = 3, max = 20, message = "Name Character must be between 10 and 20 characters long")  
    private String name_character;
    private int age;
    private double weight;
    private String history;
    
    @ManyToMany()
    private List <Movie> associated_movies;
    
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})   
    private Image image_profile;
    

}
