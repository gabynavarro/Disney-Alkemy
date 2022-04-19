package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Role;
import com.alkemy.Disney.model.Entity.User;
import com.alkemy.Disney.model.request.UserRequest;
import com.alkemy.Disney.model.response.UserResponse;
import com.alkemy.Disney.model.response.UserRoleResponse;
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
