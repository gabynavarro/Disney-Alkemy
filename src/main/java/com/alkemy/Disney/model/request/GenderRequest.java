
package com.alkemy.Disney.model.request;

import com.alkemy.Disney.model.Entity.Image;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class GenderRequest {
  
    @NotBlank
    @Size(min = 3, max = 20, message = " Name Gender must be between 10 and 20 characters long")
    private String name_gender;    
    private Image image_gender;  
}
