package com.example.clinicadentista.login;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<AppUser,Long> {


    Optional<AppUser> findByEmail(String email);
}
