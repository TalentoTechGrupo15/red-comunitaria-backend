package com.redcomunitaria.talentotech.config;

import com.redcomunitaria.talentotech.model.*;
import com.redcomunitaria.talentotech.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CSVDatabaseLoader implements CommandLineRunner {

    private static final int BATCH_SIZE = 500;

    @Autowired private RolRepository rolRepository;
    @Autowired private TipoEmprendimientoRepository tipoRepository;
    @Autowired private PaisRepository paisRepository;
    @Autowired private RegionRepository regionRepository;
    @Autowired private EtapaRepository etapaRepository;
    @Autowired private EquipoRepository equipoRepository;
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private EmprendimientoRepository emprendimientoRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        cargarRoles();
        cargarTipos();
        cargarPaises();
        cargarRegiones();
        cargarEtapas();
        cargarEquipos();
        cargarUsuarios();
        cargarEmprendimientos();
    }

    // ---------- ROLES ----------

    private void cargarRoles() throws Exception {
        if (rolRepository.count() > 0) return;

        List<Rol> lote = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/databases/rol_usuario.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);
                Rol rol = new Rol();
                rol.setNombre(data[1]);
                lote.add(rol);
            }
        }
        rolRepository.saveAll(lote);
    }

    // ---------- TIPOS EMPRENDIMIENTO ----------

    private void cargarTipos() throws Exception {
        if (tipoRepository.count() > 0) return;

        List<TipoEmprendimiento> lote = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/databases/tipo_emprendimiento.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);
                TipoEmprendimiento tipo = new TipoEmprendimiento();
                tipo.setNombre(data[1]);
                tipo.setDescripcion(data[2]);
                lote.add(tipo);
            }
        }
        tipoRepository.saveAll(lote);
    }

    // ---------- PAISES ----------

    private void cargarPaises() throws Exception {
        if (paisRepository.count() > 0) return;

        List<Pais> lote = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/databases/pais.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);
                Pais pais = new Pais();
                pais.setNombre(data[1]);
                lote.add(pais);
            }
        }
        paisRepository.saveAll(lote);
    }

    // ---------- REGIONES ----------

    private void cargarRegiones() throws Exception {
        if (regionRepository.count() > 0) return;

        Map<Long, Pais> paisesMap = paisRepository.findAll()
                .stream().collect(Collectors.toMap(Pais::getIdPais, p -> p));

        List<Region> lote = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/databases/Region_Estado_Departamento.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);
                Pais pais = paisesMap.get(Long.parseLong(data[2]));
                if (pais == null) continue;
                Region region = new Region();
                region.setNombre(data[1]);
                region.setPais(pais);
                lote.add(region);
            }
        }
        regionRepository.saveAll(lote);
    }

    // ---------- ETAPAS ----------

    private void cargarEtapas() throws Exception {
        if (etapaRepository.count() > 0) return;

        List<Etapa> lote = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/databases/etapa_emprendimiento.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);
                Etapa etapa = new Etapa();
                etapa.setNombre(data[1]);
                lote.add(etapa);
            }
        }
        etapaRepository.saveAll(lote);
    }

    // ---------- EQUIPOS ----------

    private void cargarEquipos() throws Exception {
        if (equipoRepository.count() > 0) return;

        List<Equipo> lote = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/databases/equipo.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);
                Equipo equipo = new Equipo();
                equipo.setNombre(data[1]);
                equipo.setDescripcion(data[2]);
                lote.add(equipo);
            }
        }
        equipoRepository.saveAll(lote);
    }

    // ---------- USUARIOS ----------

    private void cargarUsuarios() throws Exception {
        if (usuarioRepository.count() > 0) return;

        Map<Long, Rol> rolesMap = rolRepository.findAll()
                .stream().collect(Collectors.toMap(Rol::getIdRol, r -> r));

        Map<Long, Equipo> equiposMap = equipoRepository.findAll()
                .stream().collect(Collectors.toMap(Equipo::getIdEquipo, e -> e));

        List<Usuario> lote = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/databases/usuario.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                Rol rol = rolesMap.get(Long.parseLong(data[9]));
                if (rol == null) continue;

                Usuario usuario = new Usuario();
                usuario.setNombre(data[1]);
                usuario.setApellido(data[2]);
                usuario.setCedula(Integer.parseInt(data[3]));
                usuario.setCorreo(data[4]);
                usuario.setEdad(Integer.parseInt(data[5]));
                //usuario.setSexo(data[6]);
                usuario.setUsuario(data[7]);
                usuario.setClave(passwordEncoder.encode(data[8]));
                usuario.setRol(rol);

                if (data.length > 10 && !data[10].isBlank()) {
                    Equipo equipo = equiposMap.get(Long.parseLong(data[10].trim()));
                    if (equipo != null) usuario.setEquipo(equipo);
                }

                lote.add(usuario);

                if (lote.size() == BATCH_SIZE) {
                    usuarioRepository.saveAll(lote);
                    lote.clear();
                }
            }
        }
        if (!lote.isEmpty()) usuarioRepository.saveAll(lote);
    }

    // ---------- EMPRENDIMIENTOS ----------

    private void cargarEmprendimientos() throws Exception {
        if (emprendimientoRepository.count() > 0) return;

        Map<Long, Etapa> etapasMap = etapaRepository.findAll()
                .stream().collect(Collectors.toMap(Etapa::getIdEtapa, e -> e));
        Map<Long, Region> regionesMap = regionRepository.findAll()
                .stream().collect(Collectors.toMap(Region::getIdRegion, r -> r));
        Map<Long, TipoEmprendimiento> tiposMap = tipoRepository.findAll()
                .stream().collect(Collectors.toMap(TipoEmprendimiento::getIdTipoEmprendimiento, t -> t));
        Map<Long, Equipo> equiposMap = equipoRepository.findAll()
                .stream().collect(Collectors.toMap(Equipo::getIdEquipo, e -> e));

        List<Emprendimiento> lote = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/databases/emprendimientos_america_20000_sin_tildes.csv")))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                Etapa etapa = etapasMap.get(Long.parseLong(data[5]));
                Region region = regionesMap.get(Long.parseLong(data[6]));
                TipoEmprendimiento tipo = tiposMap.get(Long.parseLong(data[7]));
                Equipo equipo = equiposMap.get(Long.parseLong(data[8]));
                if (etapa == null || region == null || tipo == null || equipo == null) continue;

                Emprendimiento emp = new Emprendimiento();
                emp.setNombre(data[1]);
                emp.setDescripcion(data[2]);
                emp.setYear(Integer.valueOf(data[3]));
                emp.setInversion(Double.parseDouble(data[4]));
                emp.setEtapa(etapa);
                emp.setRegion(region);
                emp.setTipoEmprendimiento(tipo);
                emp.setEquipo(equipo);
                //emp.setIngresos(Double.parseDouble(data[9]));
                //emp.setEmpleados(Double.parseDouble(data[10]));
                lote.add(emp);

                if (lote.size() == BATCH_SIZE) {
                    emprendimientoRepository.saveAll(lote);
                    lote.clear();
                }
            }
        }
        if (!lote.isEmpty()) emprendimientoRepository.saveAll(lote);
    }
}
