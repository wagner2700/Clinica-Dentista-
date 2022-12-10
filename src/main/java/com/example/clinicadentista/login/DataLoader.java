package com.example.clinicadentista.login;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //criptografia do spring
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("Jose" , "jose" , "jose@dh.com", password , AppUserRoles.ROLE_USER));
        userRepository.save(new AppUser("Jose2" , "jose2" , "jose@dh.com2", password , AppUserRoles.ROLE_ADMIN));


    }
}
