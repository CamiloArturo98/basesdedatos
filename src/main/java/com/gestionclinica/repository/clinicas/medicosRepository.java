package com.gestionclinica.repository.clinicas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionclinica.config.DatabaseConnection;
import com.gestionclinica.model.Medicos;

public class medicosRepository implements Repository<Medicos> {

    private Connection getConnection()throws SQLException{
        return DatabaseConnection.getInstance();
    }

   @Override
    public List<Medicos> findNoEspecialista() throws SQLException {
        List<Medicos> medicos = new ArrayList<>();
        String sql = "SELECT nombre, apellido,especialista FROM medicos WHERE especialista IS NOT NULL";
        try(Statement myStat = getConnection().createStatement())
        {
            ResultSet resultSet = myStat.executeQuery(sql);
            while (resultSet.next()) {
                Medicos medico = new Medicos();
                medico.setNombre(resultSet.getString("nombre"));
                medico.setApellido(resultSet.getString("apellido"));
                medico.setEspecialista(resultSet.getString("especialista"));

                medicos.add(medico);
            }
        } 
        return medicos;
    }

    @Override
    public List<Medicos> findAll() throws SQLException {
        List<Medicos> medicos = new ArrayList<>();
        String sql = "SELECT nombre, apellido,especialista FROM medicos";
        try(Statement myStat = getConnection().createStatement())
        {
            ResultSet resultSet = myStat.executeQuery(sql);
            while (resultSet.next()) {
                Medicos medico = new Medicos();
                medico.setNombre(resultSet.getString("nombre"));
                medico.setApellido(resultSet.getString("apellido"));
                medico.setEspecialista(resultSet.getString("especialista"));

                medicos.add(medico);
            }
        } 
        return medicos;
    }

    @Override
    public Medicos findById(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(Medicos entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Medicos entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Medicos> findApellidoEspe() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findApellidoEspe'");
    }
                                    
}
