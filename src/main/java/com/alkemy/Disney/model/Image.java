package com.disney.disney.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

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
@ApiModel("Model Image")
@Builder
public class Image {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private String id;

    @NotBlank
    private String name_image;   
    @NotBlank
    private String fileType;
    @Lob
    @Column(name = "fileData", nullable = false, updatable = true)
    private byte[] fileData;


}
