package com.example.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.dto.UtilisateurDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JWTAuthenticationManager extends UsernamePasswordAuthenticationFilter {

     private AuthenticationManager authenticationManager;
    public JWTAuthenticationManager(AuthenticationManager authenticationManager ){
        this.authenticationManager=authenticationManager;
    }

    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException {

        ObjectMapper mapper=new ObjectMapper();
        UtilisateurDto utilisateurDto=null;

        try {
            //Convertir le contenu du body de la requête en JSON
            // vers un objet java en utilisant Jackson
            utilisateurDto=mapper
                    .readValue(request.getInputStream(),UtilisateurDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(utilisateurDto.getUsername(),utilisateurDto.getPassword()));
    }

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)throws IOException,
            ServletException {
        org.springframework.security.core.userdetails.User springUser =
                (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        List<String> roles = new ArrayList<>();
        springUser.getAuthorities().forEach(au -> {
            roles.add(au.getAuthority());});
        String jwt = JWT.create().withSubject(springUser.getUsername())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .sign(Algorithm.HMAC256("monSecret"));
        response.addHeader("Authorization", jwt);}
}
