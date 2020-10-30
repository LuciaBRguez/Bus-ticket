package com.miw.model;

import java.sql.Date;
import java.sql.Time;

public class Viaje {
	
    private int id;
    private String origen;
    private Date fecha_salida;
    private Time hora_salida;
    private String destino;
    private Integer plazas_libres;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Date getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public Time getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(Time hora_salida) {
		this.hora_salida = hora_salida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Integer getPlazas_libres() {
		return plazas_libres;
	}
	public void setPlazas_libres(Integer plazas_libres) {
		this.plazas_libres = plazas_libres;
	}
 
}
