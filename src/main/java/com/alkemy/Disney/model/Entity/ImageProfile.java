package com.alkemy.Disney.model.Entity;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ImageProfile extends IImage{

}
