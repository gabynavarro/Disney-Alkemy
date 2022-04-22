package com.alkemy.Disney.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class ResponseGenderMovie {  
    private Long id;
    private String name_gender;
   
}
