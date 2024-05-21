package com.gestionclinica.repository.clinicas;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> findAll() throws SQLException;

    List<T> findNoEspecialista() throws SQLException;
    List<T> findApellidoEspe()throws SQLException;

    T findById(int id) throws SQLException;
    void save(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
}