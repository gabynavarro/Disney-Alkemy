package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.model.Role;
import java.util.List;

public interface IRoleService {
    Role findBy(String name);
    Role findById(Long id);
    List<Role> findAll();
}
