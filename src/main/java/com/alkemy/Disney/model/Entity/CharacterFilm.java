
package com.alkemy.Disney.model.Entity;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.List;
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel("Model Character")
@Builder
@SQLDelete(sql = "UPDATE charac SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class CharacterFilm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    protected boolean deleted;    
    @NotBlank
    @Size(min = 1, max = 20, message = "Name Character must be between 1 and 20 characters long")  
    private String name_character;
    @Range (min = 1, max = 1000, message = "El rango de eddad es de 1-1000")
    private int age;    
    private double weight;
    private String history;
    
    @ManyToMany()
    private List <Movie> associated_movies;
    
    @OneToOne   
    private Image image_character;
    

}
