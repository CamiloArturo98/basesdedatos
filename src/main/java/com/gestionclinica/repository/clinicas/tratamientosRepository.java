package com.gestionclinica.repository.clinicas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionclinica.config.DatabaseConnection;
import com.gestionclinica.model.tratamientos;

public class tratamientosRepository implements Repository<tratamientos> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<tratamientos> findNoEspecialista() throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'findNoEspecialista'");
    }

    @Override
    public List<tratamientos> findAll() throws SQLException {
        List<tratamientos> tratamientosList = new ArrayList<>();
        String sql = "SELECT id, nombre, descripcion FROM tratamientos";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                tratamientos tratamiento = new tratamientos(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"), sql, null, sql, null
                );
                tratamientosList.add(tratamiento);
            }
        }
        return tratamientosList;
    }

    @Override
    public tratamientos findById(int id) throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(tratamientos entity) throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(tratamientos entity) throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<tratamientos> findApellidoEspe() throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'findApellidoEspe'");
    }

    public List<tratamientos> findByTipo(String tipoTratamiento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTipo'");
    }

    public List<tratamientos> findTratamientosLargoPlazo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTratamientosLargoPlazo'");
    }
}
