package com.alkemy.Disney.model.Entity;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
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
@ApiModel("Model Movie")
@Builder
@SQLDelete(sql = "UPDATE charac SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Movie {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected boolean deleted;
    @NotBlank
    @Size(min = 2, max = 20, message = " Name Gender must be between 2 and 20 characters long")
    private String title;
    @Past (message = "La fecha creadad es mayor que la fecha actual")
    private LocalDate date_created;
    @Range (min = 1, max = 5, message = "El rango de calificación es de 1 a 5")
    private int calificated; //del 1-5

    @OneToOne    
    private Image image_movie;
 
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_gender", joinColumns ={@JoinColumn(name = "id_movie")},
    inverseJoinColumns = {@JoinColumn(name = "id_gender")})  
    private List<Gender> genders;
    
    @ManyToMany
    private List<CharacterFilm> Character;

}
