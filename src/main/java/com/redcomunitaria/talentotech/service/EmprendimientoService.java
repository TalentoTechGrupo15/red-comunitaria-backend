package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.EmprendimientoDTO;
import com.redcomunitaria.talentotech.model.*;
import com.redcomunitaria.talentotech.repository.EmprendimientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class EmprendimientoService {

    private final EmprendimientoRepository emprendimientoRepository;
    private final EtapaService etapaService;
    private final RegionService regionService;
    private final TipoEmprendimientoService tEService;
    private final EquipoService equipoService;




    public Emprendimiento crearEmprendimiento(EmprendimientoDTO emprendimientoDTO) {

        Emprendimiento nuevoEmprendimiento = Emprendimiento.builder()
                .nombre(emprendimientoDTO.getNombre())
                .descripcion(emprendimientoDTO.getDescripcion())
                .year(emprendimientoDTO.getYear())
                .inversion(emprendimientoDTO.getInversion())
                .ingresos(emprendimientoDTO.getIngresos())
                .empleados(emprendimientoDTO.getEmpleados()).build();


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

    public List<Emprendimiento> buscarEmprendimiento(String nombre, Integer tipo, Integer pais, String agruparPor, Integer numeroResultados) {
        List<Emprendimiento> emprendimientos = emprendimientoRepository.buscarConFiltros(nombre, tipo, pais);

//        if ("pais".equalsIgnoreCase(agruparPor)) {
//            return emprendimientos.stream()
//                    .collect(Collectors.groupingBy(e -> e.getRegion().getPais().getIdPais()))
//                    .values().stream()
//                    .map(list -> list.get(0))
//                    .toList();
//        } else if ("region".equalsIgnoreCase(agruparPor)) {
//            return emprendimientos.stream()
//                    .collect(Collectors.groupingBy(e -> e.getRegion().getIdRegion()))
//                    .values().stream()
//                    .map(list -> list.get(0))
//                    .toList();
//        }
        return emprendimientos.stream().limit(numeroResultados).toList();

    }
}
