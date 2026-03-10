/*package com.redcomunitaria.talentotech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(4);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable()) // si no se desactiva falla POST/PUT/DELETE
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/emprendimiento/buscar").permitAll()
                        .requestMatchers("/etapa/listar").permitAll()
                        .requestMatchers("/pais/listar").permitAll()
                        .requestMatchers("/region/listar").permitAll()
                        .requestMatchers("/rol/listar").permitAll()
                        .requestMatchers("/sexo/listar").permitAll()
                        .requestMatchers("/tipo_emprendimiento/listar").permitAll()
                        .requestMatchers("/usuario/registro").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable());
        return http.build();

    }
}*/