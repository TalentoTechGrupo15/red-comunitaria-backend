package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.RespuestaListaDTO;
import com.redcomunitaria.talentotech.model.Pais;
import com.redcomunitaria.talentotech.repository.PaisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PaisService {

    private final PaisRepository paisRepository;

    public List<RespuestaListaDTO> obtenerPaises() {
        List<Pais> paises = paisRepository.findAll();

        return paises.stream()
                .map(pais -> new RespuestaListaDTO(pais.getIdPais(), pais.getNombre())).toList();
    }
}
