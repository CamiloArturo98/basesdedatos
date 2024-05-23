package com.gestionclinica.model;

public class pacientes {
    private Integer idPacientes;
    private String nombre;
    private String apellido;
    private Integer documentoId;
    private String noTelefono;
    private Integer idMedico;

    public pacientes(Integer idPacientes, String nombre, String apellido, Integer documentoId, String noTelefono, Integer idMedico) {
        this.idPacientes = idPacientes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoId = documentoId;
        this.noTelefono = noTelefono;
        this.idMedico = idMedico;
    }

    public pacientes(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Integer idPacientes) {
        this.idPacientes = idPacientes;
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

    public Integer getdocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Integer documentoId) {
        this.documentoId = documentoId;
    }

    public String getNoTelefono() {
        return noTelefono;
    }

    public void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
}

