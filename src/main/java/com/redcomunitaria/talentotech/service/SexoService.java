package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.RespuestaListaDTO;
import com.redcomunitaria.talentotech.model.Sexo;
import com.redcomunitaria.talentotech.repository.SexoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class SexoService {

    private SexoRepository sexoRepository;

    public List<RespuestaListaDTO> obtenerSexo() {
        return sexoRepository.findAll().stream()
                .map(sexo -> new RespuestaListaDTO(sexo.getIdSexo(), sexo.getNombre()))
                .toList();
    }

    public Sexo obtenerSexoPorId(Long id) {
        return sexoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sexo no encontrado con id: " + id));
    }
}
