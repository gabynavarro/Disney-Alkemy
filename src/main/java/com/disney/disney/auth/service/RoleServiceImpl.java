package com.disney.disney.auth.service;

import com.disney.disney.auth.model.Role;
import com.disney.disney.auth.repository.IRoleRepository;
import com.disney.disney.auth.service.abstraction.IRoleService;
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
