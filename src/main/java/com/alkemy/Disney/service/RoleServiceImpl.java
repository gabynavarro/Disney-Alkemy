package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.Role;
import com.alkemy.Disney.repository.IRoleRepository;
import com.alkemy.Disney.service.abstraction.IRoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findBy(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role findById(Long id) {
       return roleRepository.getById(id);    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
