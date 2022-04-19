package com.disney.disney.auth.request;



import com.disney.disney.auth.model.Role;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

  
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
    private List<Role> roles=new ArrayList<>();   

    public UserRegisterRequest(String email, String first_name, String last_name, String dni) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dni = dni;
    }
    

}
