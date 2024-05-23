package com.gestionclinica.repository.clinicas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionclinica.config.DatabaseConnection;
import com.gestionclinica.model.pacientes;

public class pacientesRepository implements Repository<pacientes> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<pacientes> findNoEspecialista() throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'findNoEspecialista'");
    }

    @Override
    public List<pacientes> findAll() throws SQLException {
        List<pacientes> pacientesList = new ArrayList<>();
        String sql = "SELECT nombre, apellido FROM pacientes";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                pacientes paciente = new pacientes(
                        null, resultSet.getString("nombre"),
                        resultSet.getString("apellido"), null, sql, null
                );
                pacientesList.add(paciente);
            }
        }
        return pacientesList;
    }

    @Override
    public pacientes findById(int id) throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(pacientes entity) throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(pacientes entity) throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // Implementación según sea necesaria
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<pacientes> findApellidoEspe() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findApellidoEspe'");
    }

    public List<pacientes> findByApellido(String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByApellido'");
    }

    public List<pacientes> findPacientesEnMasDeUnTratamiento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPacientesEnMasDeUnTratamiento'");
    }

    

}
