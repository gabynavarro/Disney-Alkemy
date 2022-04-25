
package com.alkemy.Disney.model.request;


import com.alkemy.Disney.model.Entity.CharacterFilm;
import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Image;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class MovieRequest {
     
    @NotEmpty
    @Size(min = 2, max = 30, message = " Name Gender must be between 2 and 30 characters long")
    private String title;
    @Past (message = "La fecha creadad es mayor que la fecha actual")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate date_created;
    @Range (min = 1, max = 5, message = "El rango de calificación es de 1 a 5")
    private int calificated; //del 1-5 
    private Image image_movie;
    @NotNull //obligatorio
    private List<Gender> gender_movie ;    
    private List<CharacterFilm> characters;
}
