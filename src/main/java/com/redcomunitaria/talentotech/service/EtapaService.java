package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.model.Etapa;
import com.redcomunitaria.talentotech.repository.EtapaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EtapaService {

    private final EtapaRepository etapaRepository;

    public Etapa buscarEtapaPorId(Long idEtapa){
        return etapaRepository.findById(idEtapa)
                .orElseThrow(() -> new RuntimeException("Etapa no encontrada"));
    }
}
