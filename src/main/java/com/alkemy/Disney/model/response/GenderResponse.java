package com.alkemy.Disney.model.response;

import com.alkemy.Disney.model.mapper.ModelImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class GenderResponse {  
    private Long id;
    private String name_gender;
    private Boolean deleted;
    private ModelImage image;
}
