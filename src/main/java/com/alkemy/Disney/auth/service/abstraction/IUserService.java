package com.disney.disney.auth.service.abstraction;

import com.disney.disney.auth.model.Role;
import com.disney.disney.auth.model.User;
import com.disney.disney.auth.request.UserRequest;
import com.disney.disney.auth.response.UserResponse;
import com.disney.disney.auth.response.UserRoleResponse;
import java.util.List;
import javassist.NotFoundException;
import javax.persistence.EntityNotFoundException;

public interface IUserService {
    
    User getInfoUser() throws NotFoundException;
    void delete(Long id)throws EntityNotFoundException;
    UserResponse update(Long id, UserRequest request)throws NotFoundException;
    UserResponse getById(Long id);
    List<UserResponse> getAllUser();
    UserRoleResponse updateRoles(Long id , List<Role> roles);
    List<UserResponse> getByFilters(String email, String first_name, String last_name, String dni);
}
