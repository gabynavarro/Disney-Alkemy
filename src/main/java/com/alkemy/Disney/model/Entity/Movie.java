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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@ApiModel("Model Movie")
@Builder
public class Movie {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected boolean deleted;
    @NotBlank
    @Size(min = 10, max = 20, message = " Name Gender must be between 10 and 20 characters long")
    private String title;

    private LocalDate date_created;
    private int calificated; //del 1-5

    @OneToOne
    @JoinColumn(name="image_movie")  
    private ImageProfile image_movie;
    @ManyToOne
    private Gender gender_movie;
    
    @ManyToMany
    private List<CharacterFilm> Character;

}
