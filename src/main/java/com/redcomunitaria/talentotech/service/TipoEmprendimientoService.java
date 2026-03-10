package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.RespuestaListaDTO;
import com.redcomunitaria.talentotech.model.TipoEmprendimiento;
import com.redcomunitaria.talentotech.repository.TipoEmprendimientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TipoEmprendimientoService {

    private final TipoEmprendimientoRepository tipoEmprendimientoRepository;

    public TipoEmprendimiento buscarTipoEmprendimientoPorId(Long idTipoEmprendimiento){
        return tipoEmprendimientoRepository.findById(idTipoEmprendimiento)
                .orElseThrow(() -> new RuntimeException("Tipo de emprendimiento no encontrado"));
    }

    public List<RespuestaListaDTO> obtenerTiposEmprendimiento() {
        return tipoEmprendimientoRepository.findAll().stream()
                .map(tipo -> new RespuestaListaDTO(tipo.getIdTipoEmprendimiento(), tipo.getNombre()))
                .toList();
    }
}
