package com.gestionclinica.model;

public class pacientes {
    private Integer idpacientes;
    private String nombre;
    private String apellido;
    private Integer documento_id;
    private String no_telefono;
    private Integer id_medico;

    public pacientes(){

    }
    public pacientes(Integer idPacientes, String nombre , String apellido, Integer documento_id, String no_telefono, Integer id_medico){
        this.idpacientes = idPacientes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento_id = documento_id;
        this.no_telefono = no_telefono;
        this.id_medico = id_medico;
    }
    public Integer getIdpacientes() {
        return idpacientes;
    }
    public void setIdpacientes(Integer idpacientes) {
        this.idpacientes = idpacientes;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getDocumento_id() {
        return documento_id;
    }
    public void setDocumento_id(Integer documento_id) {
        this.documento_id = documento_id;
    }
    public String getNo_telefono() {
        return no_telefono;
    }
    public void setNo_telefono(String no_telefono) {
        this.no_telefono = no_telefono;
    }
    public Integer getId_medico() {
        return id_medico;
    }
    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }
}
