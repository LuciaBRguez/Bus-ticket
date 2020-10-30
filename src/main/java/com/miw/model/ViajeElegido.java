package com.miw.model;


public class ViajeElegido {
	
    private String origen;
    private String destino;
    private String fecha_ida;
    private Integer id_ida;
    private boolean vuelta;
    private String fecha_vuelta;
    private Integer id_vuelta;
    private Integer num_viajeros;
    
    
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFecha_ida() {
		return fecha_ida;
	}
	public void setFecha_ida(String fecha_ida) {
		this.fecha_ida = fecha_ida;
	}
	public Integer getId_ida() {
		return id_ida;
	}
	public void setId_ida(Integer id_ida) {
		this.id_ida = id_ida;
	}
	public boolean isVuelta() {
		return vuelta;
	}
	public void setVuelta(boolean vuelta) {
		this.vuelta = vuelta;
	}
	public String getFecha_vuelta() {
		return fecha_vuelta;
	}
	public void setFecha_vuelta(String fecha_vuelta) {
		this.fecha_vuelta = fecha_vuelta;
	}
	public Integer getId_vuelta() {
		return id_vuelta;
	}
	public void setId_vuelta(Integer id_vuelta) {
		this.id_vuelta = id_vuelta;
	}
	public Integer getNum_viajeros() {
		return num_viajeros;
	}
	public void setNum_viajeros(Integer num_viajeros) {
		this.num_viajeros = num_viajeros;
	}

}
