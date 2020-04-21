package com.sf_ecommerce.fncom.repository;

import com.sf_ecommerce.fncom.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        User findByUsername(String username);
        boolean existsUsersByEmail(String email);

        User findByEmail(String email);
}
