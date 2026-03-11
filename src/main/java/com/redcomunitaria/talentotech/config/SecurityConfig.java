package com.redcomunitaria.talentotech.config;

import com.redcomunitaria.talentotech.jwt.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable()) // si no se desactiva falla POST/PUT/DELETE
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/emprendimiento/buscar/**").permitAll()
                        .requestMatchers("/emprendimiento/buscar").permitAll()
                        .requestMatchers("/etapa/listar").permitAll()
                        .requestMatchers("/pais/listar").permitAll()
                        .requestMatchers("/region/listar").permitAll()
                        .requestMatchers("/rol/listar").permitAll()
                        .requestMatchers("/sexo/listar").permitAll()
                        .requestMatchers("/tipo_emprendimiento/listar").permitAll()
                        .requestMatchers("/usuario/registro").permitAll()
                        .requestMatchers("/usuario/login").permitAll()
                        .requestMatchers("/equipo/buscar/**").permitAll()
                        .requestMatchers("/equipo/buscar").permitAll()
                        .anyRequest().authenticated())
                //.formLogin(form -> form.disable())
                .sessionManagement(sessionManager ->
                        sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
}