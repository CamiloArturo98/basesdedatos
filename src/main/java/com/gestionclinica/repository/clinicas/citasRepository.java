package com.gestionclinica.repository.clinicas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionclinica.config.DatabaseConnection;
import com.gestionclinica.model.citas;

public class citasRepository implements Repository<citas> {
    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<citas> findAll() throws SQLException {
        List<citas> citasArray = new ArrayList<>();
        String sql = "SELECT * FROM citas ORDER BY fecha";
        try(Statement myStat = getConnection().createStatement())
        {
            ResultSet resultSet = myStat.executeQuery(sql);
            while (resultSet.next()) {
                citas cita = new citas(
                    resultSet.getInt("idCitas"),
                    resultSet.getInt("id_pacientes"),
                    resultSet.getTime("Hora"),
                    resultSet.getDate("fecha"),
                    resultSet.getString("sede"),
                    resultSet.getInt("no_consultorio"),
                    resultSet.getInt("id_medico")
                );
                citasArray.add(cita);
            }
        } 
        return citasArray;
}


    @Override
    public citas findById(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(citas entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(citas entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<citas> findNoEspecialista() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findNoEspecialista'");
    }

    @Override
    public List<citas> findApellidoEspe() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findApellidoEspe'");
    }
}
