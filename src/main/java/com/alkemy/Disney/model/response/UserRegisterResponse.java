package com.alkemy.Disney.model.response;

import com.alkemy.Disney.model.Entity.Role;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterResponse {

    private Long id;
    private String email;  
    private String token;
    private String firstName;
    private String lastName;
    private List<Role> roles;
   


}
