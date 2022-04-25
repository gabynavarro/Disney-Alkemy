
package com.alkemy.Disney.model.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ListMovieResponse {
    private Long id;  
    private String title;   
    private LocalDate date_created;  
    private ModelImage image_movie;  
}
