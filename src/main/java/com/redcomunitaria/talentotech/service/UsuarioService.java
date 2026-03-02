package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.UsuarioDTO;
import com.redcomunitaria.talentotech.exception.CedulaYaExisteExcepcion;
import com.redcomunitaria.talentotech.exception.CorreoYaExisteExcepcion;
import com.redcomunitaria.talentotech.exception.UsuarioYaExisteExcepcion;
import com.redcomunitaria.talentotech.model.Rol;
import com.redcomunitaria.talentotech.model.Usuario;
import com.redcomunitaria.talentotech.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolService rolService;



    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {

        if(usuarioRepository.existsByUsuario(usuarioDTO.getUsuario())){
            throw new UsuarioYaExisteExcepcion("El nombre de usuarioDTO ya existe");
        }
        if(usuarioRepository.existsByCorreo(usuarioDTO.getCorreo())){
            throw new CorreoYaExisteExcepcion("El correo ya existe");
        }
        if(usuarioRepository.existsByCedula(usuarioDTO.getCedula())){
            throw new CedulaYaExisteExcepcion("La cedula ya existe");
        }
        Rol rol = rolService.obtenerRolPorId(1L);

        // Se convierte DTO a entidad
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(usuarioDTO.getNombre());
        nuevoUsuario.setApellido(usuarioDTO.getApellido());
        nuevoUsuario.setCedula(usuarioDTO.getCedula());
        nuevoUsuario.setCorreo(usuarioDTO.getCorreo());
        nuevoUsuario.setEdad(usuarioDTO.getEdad());
        nuevoUsuario.setSexo(usuarioDTO.getSexo());
        nuevoUsuario.setUsuario(usuarioDTO.getUsuario());
        nuevoUsuario.setClave(usuarioDTO.getClave());
        nuevoUsuario.setRol(rol);


        return usuarioRepository.save(nuevoUsuario);
        
      
    }
}
