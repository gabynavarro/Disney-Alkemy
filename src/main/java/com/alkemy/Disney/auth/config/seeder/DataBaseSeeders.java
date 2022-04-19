package com.alkemy.Disney.auth.config.seeder;


import com.alkemy.Disney.model.Entity.ListRole;
import com.alkemy.Disney.model.Entity.Role;
import com.alkemy.Disney.model.Entity.User;
import com.alkemy.Disney.repository.IRoleRepository;
import com.alkemy.Disney.repository.IUserRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataBaseSeeders {

    private static final String PASSWORD = "12345678";
    private static final String HOST_EMAIL = "@test.com";
    private static final String firstNameUser[] = {"Gabriel", "Abel", "Tomas"};
    private static final String lastNameUser[] = {"Navarro", "Acevedo", "Padilla"};    

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {
        if (roleRepository.findAll().isEmpty()) {
            createRoles();
        } 
        if (userRepository.findAll().isEmpty()) {
            createUsers();
        }
       
    }
   

    private void createRoles() {
        createRole(1L, ListRole.USER);
        createRole(2L, ListRole.ADMIN);    
    }

  
    private void createUsers() {
        createUsers(ListRole.ADMIN);
        createUsers(ListRole.USER);        
    }

    private Integer calcAge() {
        return (int) (Math.random() * (90 - 18 + 1) + 18);
    }
  

    private void createUsers(ListRole applicationRole) {

        for (int index = 0; index < 3; index++) {
            userRepository.save(
                 User.builder()
                .firstName(firstNameUser[index])
                .lastName(lastNameUser[index])
                .email(applicationRole.getName().toLowerCase() + (index + 1) + HOST_EMAIL)
                .password(passwordEncoder.encode(PASSWORD))
                .roles(createListRole(applicationRole))
             .build());
        }
    }

    private List<Role> createListRole(ListRole applicationRole) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName(applicationRole.getFullRoleName()));
        return roles;
    }

  
       private void createRole(Long id, ListRole applicationRole) {
        Role role = new Role();
        role.setId(id);
        role.setName(applicationRole.getFullRoleName());
        role.setDescription(applicationRole.getName());
        roleRepository.save(role);
    }

 
}
