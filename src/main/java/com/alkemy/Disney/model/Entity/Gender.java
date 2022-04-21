package com.alkemy.Disney.model.Entity;

import io.swagger.annotations.ApiModel;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel("Model Gender")
@Builder
@SQLDelete(sql = "UPDATE charac SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected boolean deleted;
    @NotBlank
    @Size(min = 3, max = 20, message = " Name Gender must be between 10 and 20 characters long")
    private String name_gender;
    
    @OneToOne
    @JoinColumn(name="image_gender")  
    private Image image_gender;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "genders")
    private List<Movie> movies;

}
