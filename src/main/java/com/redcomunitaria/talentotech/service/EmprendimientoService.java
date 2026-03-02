package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.EmprendimientoDTO;
import com.redcomunitaria.talentotech.model.*;
import com.redcomunitaria.talentotech.repository.EmprendimientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EmprendimientoService {

    private final EmprendimientoRepository emprendimientoRepository;
    private final EtapaService etapaService;
    private final RegionService regionService;
    private final TipoEmprendimientoService tEService;
    private final EquipoService equipoService;



    /* AGREGAR EXCEPCION SI EL NOMBRE DEL EMPRENDIMIENTO YA EXISTE */
    public Emprendimiento crearEmprendimiento(EmprendimientoDTO emprendimientoDTO) {

        Emprendimiento nuevoEmprendimiento = new Emprendimiento();
        nuevoEmprendimiento.setNombre(emprendimientoDTO.getNombre());
        nuevoEmprendimiento.setDescripcion(emprendimientoDTO.getDescripcion());
        nuevoEmprendimiento.setYear(emprendimientoDTO.getYear());
        nuevoEmprendimiento.setInversion(emprendimientoDTO.getInversion());

        Etapa nuevaEtapa = etapaService.buscarEtapaPorId(emprendimientoDTO.getIdEtapa());
        nuevoEmprendimiento.setEtapa(nuevaEtapa);

        Region nuevaRegion = regionService.buscarRegionPorId(emprendimientoDTO.getIdRegion());
        nuevoEmprendimiento.setRegion(nuevaRegion);

        TipoEmprendimiento nuevoTE = tEService.buscarTipoEmprendimientoPorId(emprendimientoDTO.getIdTipoEmprendimiento());
        nuevoEmprendimiento.setTipoEmprendimiento(nuevoTE);

        Equipo equipoDelEmprendimiento = equipoService.buscarEquipoPorId(emprendimientoDTO.getIdEquipo());
        if(equipoDelEmprendimiento.getEmprendimiento() != null){
            throw new RuntimeException("El equipo ya tiene otro emprendimiento");
        }

        nuevoEmprendimiento.setEquipo(equipoDelEmprendimiento);

        Emprendimiento e = emprendimientoRepository.save(nuevoEmprendimiento);

        equipoDelEmprendimiento.setEmprendimiento(nuevoEmprendimiento);
        return e;
    }
}
