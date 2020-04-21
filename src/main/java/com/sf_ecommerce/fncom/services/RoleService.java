package com.sf_ecommerce.fncom.services;

import com.sf_ecommerce.fncom.entities.users.Role;
import com.sf_ecommerce.fncom.enums.RoleName;
import com.sf_ecommerce.fncom.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findByName(RoleName name) {
        return roleRepository.findByName(name);
    }

    public boolean roleExists(RoleName name) {
        return roleRepository.existsRoleByName(name);
    }

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public void save(Role role) {
    }

}
