package com.sf_ecommerce.fncom.repository;

import com.sf_ecommerce.fncom.entities.users.Role;
import com.sf_ecommerce.fncom.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsRoleByName(RoleName name);
    Role findByName(RoleName name);
    Optional<Role> findById(Long id);
}
