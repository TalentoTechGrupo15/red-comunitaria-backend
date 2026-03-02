package com.redcomunitaria.talentotech.repository;

import com.redcomunitaria.talentotech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
    Usuario findByCorreo(String correo);
    Usuario findByCedula(Integer cedula);

    Boolean existsByUsuario(String usuario);
    Boolean existsByCorreo(String correo);
    Boolean existsByCedula(Integer cedula);




}
