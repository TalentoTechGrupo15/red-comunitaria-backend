package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.RespuestaListaDTO;
import com.redcomunitaria.talentotech.model.Etapa;
import com.redcomunitaria.talentotech.repository.EtapaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EtapaService {

    private final EtapaRepository etapaRepository;

    public Etapa buscarEtapaPorId(Long idEtapa){
        return etapaRepository.findById(idEtapa)
                .orElseThrow(() -> new RuntimeException("Etapa no encontrada"));
    }

    public List<RespuestaListaDTO> obtenerEtapas() {
        return etapaRepository.findAll().stream()
                .map(etapa -> new RespuestaListaDTO(etapa.getIdEtapa(), etapa.getNombre()))
                .toList();
    }
}
