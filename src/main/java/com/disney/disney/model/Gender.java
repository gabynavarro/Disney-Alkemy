
package com.disney.disney.model;

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
@ApiModel("Model Gender")
@Builder
public class Gender extends  BaseClass {
    
 @NotBlank
 @Size(min = 10, max = 20, message = " Name Gender must be between 10 and 20 characters long")   
 private String name_gender;
 
 @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})   
 private Image image_gender;
 
 @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
 private List<Movie> movies;

}
