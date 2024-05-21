package com.gestionclinica.repository.clinicas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.gestionclinica.config.DatabaseConnection;
import com.gestionclinica.model.pacientes;

public class pacientesRepository implements Repository {

    private Connection getConnection()throws SQLException{
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<pacientes> findApellidoEspe() throws SQLException{
        List<pacientes> paciApellido = new ArrayList<>();
        String sql = "SELECT *FROM pacientes WHERE apellido = 'Gonzales';";
        try(Statement myStat = getConnection().createStatement())
        {
            ResultSet resultSet = myStat.executeQuery(sql);
            while (resultSet.next()) {
                pacientes paci = new pacientes();
                paci.setApellido(resultSet.getString("apellido"));

                paciApellido.add(paci);
            }
        } 
        return paciApellido;
    }
    
    @Override
    public List findAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List findNoEspecialista() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findNoEspecialista'");
    }

    @Override
    public Object findById(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(Object entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Object entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
