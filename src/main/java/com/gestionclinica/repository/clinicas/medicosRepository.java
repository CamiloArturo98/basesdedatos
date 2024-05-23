package com.gestionclinica.repository.clinicas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionclinica.config.DatabaseConnection;
import com.gestionclinica.model.Medicos;
import com.gestionclinica.model.pacientes;

public class medicosRepository implements Repository<Medicos> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Medicos> findNoEspecialista() throws SQLException {
        List<Medicos> medicos = new ArrayList<>();
        String sql = "SELECT nombre, apellido, especialista FROM medicos WHERE especialista IS NOT NULL";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Medicos medico = new Medicos(
                        null, resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("especialista"), sql
                );
                medicos.add(medico);
            }
        }
        return medicos;
    }

    @Override
    public List<Medicos> findAll() throws SQLException {
        List<Medicos> medicos = new ArrayList<>();
        String sql = "SELECT nombre, apellido, especialista FROM medicos";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Medicos medico = new Medicos(
                        null, resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("especialista"), sql
                );
                medicos.add(medico);
            }
        }
        return medicos;
    }

    @Override
    public Medicos findById(int id) throws SQLException {
        // Implementación no disponible
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(Medicos entity) throws SQLException {
        // Implementación no disponible
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Medicos entity) throws SQLException {
        // Implementación no disponible
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // Implementación no disponible
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Medicos> findApellidoEspe() throws SQLException {
        // Implementación no disponible
        throw new UnsupportedOperationException("Unimplemented method 'findApellidoEspe'");
    }

    public List<pacientes> findByApellido(String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByApellido'");
    }

    public List<Object[]> findMedicosSupervisanTratamientos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findMedicosSupervisanTratamientos'");
    }
}
