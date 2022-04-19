package com.alkemy.Disney.model.response;

import com.alkemy.Disney.model.model.Role;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String firt_name;
    private String last_name;
    private int age;   
    private String dni;    
    private String image_url;
    private String country;
    private String province;
    private String city;
    private List<Role> roles;

}
