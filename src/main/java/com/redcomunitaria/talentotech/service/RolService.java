package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.model.Rol;
import com.redcomunitaria.talentotech.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    public Rol obtenerRolPorId(Long idRol) {
        return rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + idRol));
    }
}
