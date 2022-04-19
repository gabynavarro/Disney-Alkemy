package com.disney.disney.auth.service.abstraction;

import com.disney.disney.auth.model.Role;
import java.util.List;

public interface IRoleService {
    Role findBy(String name);
    Role findById(Long id);
    List<Role> findAll();
}
