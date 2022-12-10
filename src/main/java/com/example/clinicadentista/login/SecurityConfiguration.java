package com.example.clinicadentista.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configurationgit add
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //Desabilitação pois navegadores automaticamente ja abrem para fazer login
        //estamos desabilitando essa opção
        http.csrf().disable()
                .authorizeRequests().permitAll()
                .antMatchers("/user").hasHole("USER")
                .antMatchers("/admin").hasHole("ADMIN")
                .anyRequest()
                .authenticated().and()
                .formLogin();


    }
}
