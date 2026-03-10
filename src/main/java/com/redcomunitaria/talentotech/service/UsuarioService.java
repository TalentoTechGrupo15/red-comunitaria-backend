package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.*;
import com.redcomunitaria.talentotech.exception.CedulaYaExisteExcepcion;
import com.redcomunitaria.talentotech.exception.CorreoYaExisteExcepcion;
import com.redcomunitaria.talentotech.exception.UsuarioYaExisteExcepcion;
import com.redcomunitaria.talentotech.exception.UsuarioYaTieneEquipoExcepcion;
import com.redcomunitaria.talentotech.jwt.JwtService;
import com.redcomunitaria.talentotech.model.*;
import com.redcomunitaria.talentotech.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolService rolService;
    private final EquipoService equipoService;
    private final SexoService sexoService;
    private final EmprendimientoService emprendimientoService;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public LoginResponseDTO iniciarSesion(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsuario(), loginRequestDTO.getClave()));
        //UserDetails userDetails = usuarioRepository.findByUsuario(loginRequestDTO.getUsuario());

        Usuario usuario = usuarioRepository.findByUsuario(loginRequestDTO.getUsuario());
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        Long idEquipo = null;
        Long idEmprendimiento = null;

        if (usuario.getEquipo() != null) {
            idEquipo = usuario.getEquipo().getIdEquipo();
            if (usuario.getEquipo().getEmprendimiento() != null) {
                idEmprendimiento = usuario.getEquipo().getEmprendimiento().getIdEmprendimiento();
            }
        }

        return LoginResponseDTO.builder()
                .usuario(usuario.getUsername())
                .idEmprendimiento(idEmprendimiento)
                .idEquipo(idEquipo)
                .token(jwtService.getToken(usuario))
                .build();
    }



    public LoginResponseDTO crearUsuario(UsuarioDTO usuarioDTO) {

        if(usuarioRepository.existsByUsuario(usuarioDTO.getUsuario())){
            throw new UsuarioYaExisteExcepcion("El nombre de usuario ya existe");
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

        Sexo sexoUsuario = sexoService.obtenerSexoPorId(usuarioDTO.getSexo());
        nuevoUsuario.setSexo(sexoUsuario);

        nuevoUsuario.setUsuario(usuarioDTO.getUsuario());
        nuevoUsuario.setClave(passwordEncoder.encode(usuarioDTO.getClave()));
        nuevoUsuario.setRol(rol);


        Usuario usuarioRegistrado = usuarioRepository.save(nuevoUsuario);

        return LoginResponseDTO.builder()
                .usuario(usuarioRegistrado.getUsuario())
                .idEmprendimiento(null)
                .idEquipo(null)
                .token(jwtService.getToken(usuarioRegistrado))
                .build();
    }




    public Equipo crearEquipo(EquipoDTO equipoDTO) {

        List<Usuario> integrantes = new ArrayList<>();

        equipoDTO.getIntegrantes().forEach(nombreDeUsuario ->{
            if(!usuarioRepository.existsByUsuario(nombreDeUsuario)){
                throw new UsuarioYaExisteExcepcion("El siguiente nombre de usuario no existe: " + nombreDeUsuario);
            }

            Usuario integrante = usuarioRepository.findByUsuario(nombreDeUsuario);
            if(integrante.getEquipo() != null){
                throw new UsuarioYaTieneEquipoExcepcion("El siguiente usuario ya pertenece a un equipo: " + nombreDeUsuario);
            }
            integrantes.add(integrante);
        });


        Equipo nuevoEquipo = new Equipo();
        nuevoEquipo.setNombre(equipoDTO.getNombre());
        nuevoEquipo.setDescripcion(equipoDTO.getDescripcion());

        Equipo equipoCreado = equipoService.crearEquipo(nuevoEquipo);

        integrantes.forEach(integranteEquipo ->{
            integranteEquipo.setEquipo(equipoCreado);
            usuarioRepository.save(integranteEquipo);
        });

        return equipoCreado;



    }


}
