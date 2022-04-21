package com.alkemy.Disney.model.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image implements Serializable {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")

    private String id;

    @Column(name = "name", nullable = false, updatable = true)
    private String name_image;

    @Column(name = "fileType", nullable = false, updatable = true)
    private String fileType;

    @Lob 
    @Column(name = "fileData", nullable = false, updatable = true)
    private byte[] fileData;


}
