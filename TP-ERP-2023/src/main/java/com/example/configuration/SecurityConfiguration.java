package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;
    
     BCryptPasswordEncoder passwordEncoder;



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	if(passwordEncoder==null) {
    		this.passwordEncoder= new BCryptPasswordEncoder();
    	}
    	
        return this.passwordEncoder;
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
    	this.passwordEncoder= new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.PUT, "/produit/*").hasAnyRole("USER", "FOURNISSEUR")
                .antMatchers(HttpMethod.POST, "/produit").hasRole("FOURNISSEUR")
                .antMatchers(HttpMethod.DELETE, "/produit/*").hasRole("FOURNISSEUR")
                .antMatchers(HttpMethod.GET,"/produit/**").permitAll()
                .antMatchers(HttpMethod.POST, "/client").hasRole("FOURNISSEUR")
                .antMatchers(HttpMethod.GET,"/client/**").hasAnyRole("USER", "FOURNISSEUR")
                .anyRequest().denyAll()
                .and()
                .csrf().disable()
                .formLogin().disable();
        return http.build();
    }

}
