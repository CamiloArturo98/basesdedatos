package com.gestionclinica;

import com.gestionclinica.model.Medicos;
import com.gestionclinica.repository.clinicas.medicosRepository;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia del repositorio de médicos
        medicosRepository repository = new medicosRepository();

        try {
            // Llamamos al método para encontrar médicos especialistas
            List<Medicos> especialistas = repository.findNoEspecialista();

            // Iteramos sobre la lista de médicos especialistas y mostramos sus nombres y apellidos
            for (Medicos medico : especialistas) {
                System.out.println("Nombre: " + medico.getNombre() + ", Apellido: ");
            }
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error al acceder a la base de datos
            e.printStackTrace();
        }
    }
}
