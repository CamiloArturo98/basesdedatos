package com.gestionclinica.model;

public class tratamientos {
    private Integer idTratamientos;
    private String Tipo_tratamiento;
    private String hora;
    private String cantidad;
    private Integer tiempo_consumo;
    private String Direccion;
    private Integer idpacientes;
    
    public tratamientos(){

    }
    public tratamientos(Integer idTratamientos, String Tipo_tratamiento, String hora, String cantidad, Integer tiempo_consumo, String Direccion, Integer idPacientes){
        this.idTratamientos= idTratamientos;
        this.Tipo_tratamiento = Tipo_tratamiento;
        this.hora = hora;
        this.cantidad = cantidad;
        this.tiempo_consumo =  tiempo_consumo;
        this.Direccion  = Direccion;
        this.idpacientes = idPacientes;
    }
    public Integer getIdTratamientos() {
        return idTratamientos;
    }
    public void setIdTratamientos(Integer idTratamientos) {
        this.idTratamientos = idTratamientos;
    }
    public String getTipo_tratamiento() {
        return Tipo_tratamiento;
    }
    public void setTipo_tratamiento(String tipo_tratamiento) {
        Tipo_tratamiento = tipo_tratamiento;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public Integer getTiempo_consumo() {
        return tiempo_consumo;
    }
    public void setTiempo_consumo(Integer tiempo_consumo) {
        this.tiempo_consumo = tiempo_consumo;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public Integer getIdpacientes() {
        return idpacientes;
    }
    public void setIdpacientes(Integer idpacientes) {
        this.idpacientes = idpacientes;
    }

    
}
