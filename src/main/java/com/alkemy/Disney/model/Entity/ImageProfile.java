package com.alkemy.Disney.model.Entity;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;


@Entity
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class ImageProfile extends Image{

}
