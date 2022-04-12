package com.disney.disney.auth.mapper;

import com.disney.disney.auth.model.User;
import com.disney.disney.auth.request.UserRegisterRequest;
import com.disney.disney.auth.request.UserRequest;
import com.disney.disney.auth.response.UserRegisterResponse;
import com.disney.disney.auth.response.UserResponse;
import com.disney.disney.auth.response.UserRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
 

    public User userDto2Entity(UserRegisterRequest request, MultipartFile[] file) {
        User user = new User();
//        String imageUrl = service.subirImagen(file);
        user.setEmail(request.getEmail());
//        user.setAge(request.getAge());
//        user.setCity(request.getCity());
//        user.setCountry(request.getCountry());
//        user.setDni(request.getDni());
//        user.setFirstName(request.getFirst_name());
//        user.setLastName(request.getLast_name());
//        user.setImageUrl(imageUrl);
//        user.setProvince(request.getProvince());
//        user.setRoles(null);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return user;        
    }

    public UserRegisterResponse userEntity2Dto(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setId(user.getId());
//        userRegisterResponse.setFirstName(user.getFirstName());
//        userRegisterResponse.setLastName(user.getLastName());
//        userRegisterResponse.setEmail(user.getEmail());
//        userRegisterResponse.setRoles(user.getRoles());
       
        return userRegisterResponse;
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
