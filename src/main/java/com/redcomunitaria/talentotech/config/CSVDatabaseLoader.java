package com.redcomunitaria.talentotech.config;

import com.redcomunitaria.talentotech.model.Rol;
import com.redcomunitaria.talentotech.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CSVDatabaseLoader implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public void run(String... args) throws Exception {

        // Si ya hay datos en la tabla, no cargar nuevamente
        if (rolRepository.count() > 0) {
            return;
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        getClass().getResourceAsStream("/databases/rol_usuario.csv")
                )
        );

        String line;

        // Saltar la primera línea (encabezados del CSV)
        reader.readLine();

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            Rol rol = new Rol();
            rol.setNombre(data[1]);

            rolRepository.save(rol);
        }

        reader.close();
    }
}
