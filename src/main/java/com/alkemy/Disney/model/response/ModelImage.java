package com.alkemy.Disney.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelImage {
    private String idImage;
    private String imageName;
    private String urlImage;
}
