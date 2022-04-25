
package com.alkemy.Disney.model.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Builder @AllArgsConstructor
@NoArgsConstructor
public class ModelMovie {
    private Long id;  
    private String title;   
    private LocalDate date_created;  
}
