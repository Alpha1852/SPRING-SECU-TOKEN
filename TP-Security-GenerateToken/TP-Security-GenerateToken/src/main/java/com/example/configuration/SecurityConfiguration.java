package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
  public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {

      http.authorizeHttpRequests()
              .antMatchers(HttpMethod.POST, "/login").permitAll()
              .anyRequest().denyAll()
              .and()
              .addFilter(new JWTAuthenticationManager(

                      authenticationManager(http.getSharedObject(AuthenticationConfiguration.class)
              )))
              .csrf().disable()
              .formLogin().disable();
      return http.build();
  }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
        //username = anais
        //password = anais
        // UserDetailsService -> username =anais password $jhjkhjjke ROLE_ADMIN
    }
}
