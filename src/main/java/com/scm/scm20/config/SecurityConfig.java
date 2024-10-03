package com.scm.scm20.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class SecurityConfig {

    //user create and login using java code with in memory service
    @Bean
    public UserDetailsService userDetailsService(){


        UserDetails user1=User
        .withDefaultPasswordEncoder()
        .username("admin123")
        .password("admin")
        .roles("ADMIN","USER")
        .build(); 
        var inMemoryUserDetailsManager=new InMemoryUserDetailsManager(user1);
        return inMemoryUserDetailsManager;
    }
}
