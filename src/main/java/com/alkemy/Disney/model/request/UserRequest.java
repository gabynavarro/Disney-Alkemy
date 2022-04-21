
package com.alkemy.Disney.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull (message = "El email no puede estar vacío")
    private String email;
    @NotNull (message = "La contraseña no puede estar vacía")
    @Size(min = 6, max = 25, message = "La contraseña debe ser entre 6 y 25 caracteres")
    private String password;
    @NotNull(message = "El nombre no puede estar vacío ni ser nulo")
    @Pattern(regexp = "[a-zA-Z]+", message = "El nombre no puede contener números")
    private String first_name;
    @NotNull(message = "El Apellido no puede estar vacío ni ser nulo")
    @Pattern(regexp = "[a-zA-Z]+", message = "El apellido no puede contener números")
    private String last_name;
    @NotNull (message = "La edad no puede estar vacío")
    private int age;
    @NotNull (message = "El dni no puede estar vacío")
    private String dni;    
    private String image_url;
    private String country;
    private String province;
    private String city;
    
    
}
