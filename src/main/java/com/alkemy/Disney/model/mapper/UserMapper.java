package com.alkemy.Disney.model.mapper;

import com.alkemy.Disney.model.Entity.User;
import com.alkemy.Disney.model.request.UserRegisterRequest;
import com.alkemy.Disney.model.request.UserRequest;
import com.alkemy.Disney.model.response.UserRegisterResponse;
import com.alkemy.Disney.model.response.UserResponse;
import com.alkemy.Disney.model.response.UserRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
 

    public User userDto2Entity(UserRegisterRequest request, MultipartFile[] file) {
        return User.builder()
                .email(request.getEmail())
                .firstName(request.getFirst_name())
                .lastName(request.getLast_name())
                .password(passwordEncoder.encode(request.getPassword()))                
                .build();     
    }

    public UserRegisterResponse userEntity2Dto(User user) {
          return UserRegisterResponse.builder()
                  .id(user.getId())
                  .email(user.getEmail())
                  .firstName(user.getFirstName())
                  .lastName(user.getLastName())                 
                  .roles(user.getRoles())                  
                  .build();
    }
//
    public User userDtoEntity(User entity, UserRequest request) {
//        entity.setAge(request.getAge());
//        entity.setEmail(request.getEmail());
//        entity.setAge(request.getAge());
//        entity.setCity(request.getCity());
//        entity.setCountry(request.getCountry());
//        entity.setDni(request.getDni());
//        entity.setFirstName(request.getFirst_name());
//        entity.setLastName(request.getLast_name());
//        entity.setImageUrl(request.getImage_url());
//        entity.setProvince(request.getProvince());      
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        return entity;

    }
    
    
    public UserResponse convertTo(User userInstance) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userInstance.getId());
//        userResponse.setFirt_name(userInstance.getFirstName());
//        userResponse.setAge(userInstance.getAge() );
//        userResponse.setDni(userInstance.getDni());
//        userResponse.setLast_name(userInstance.getLastName());        
//        userResponse.setUsername(userInstance.getUsername());
//        userResponse.setCity(userInstance.getCity());
//        userResponse.setCountry(userInstance.getCountry());
//        userResponse.setEmail(userInstance.getEmail());
//        userResponse.setPassword(userInstance.getPassword());
//        userResponse.setImage_url(userInstance.getImageUrl());
//        userResponse.setProvince(userInstance.getProvince());
//        userResponse.setRoles(userInstance.getRoles());
        return userResponse;
    }
    
    public UserRoleResponse convertToUserRole(User user) {
        UserRoleResponse userResponse = new UserRoleResponse();
        userResponse.setId(user.getId());
//        userResponse.setFirt_name(user.getFirstName());
      //  userResponse.setRoles(user.getRoles());
        return userResponse;
    }
    
    
}
