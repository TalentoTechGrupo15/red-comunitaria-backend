package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.model.Region;
import com.redcomunitaria.talentotech.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public Region buscarRegionPorId(Long idRegion){
        return regionRepository.findById(idRegion)
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));
    }
}
