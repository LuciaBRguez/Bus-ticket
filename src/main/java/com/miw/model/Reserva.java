package com.miw.model;

public class Reserva {

	private Integer id;
	// Viaje elegido
    private Integer id_ida;
    private boolean vuelta;
    private Integer id_vuelta;
    private Integer num_viajeros;
    // Extras
    private boolean bicicleta;
	private boolean mascota;
	private boolean tabla_surf;
	private boolean esquies;
	private boolean seguro;
	// Datos pago
	private String nombre;
	private String apellidos;
	private String tipo_identificacion;
	private String identificacion;
	private String email;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public boolean isBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(boolean bicicleta) {
		this.bicicleta = bicicleta;
	}
	public boolean isMascota() {
		return mascota;
	}
	public void setMascota(boolean mascota) {
		this.mascota = mascota;
	}
	public boolean isTabla_surf() {
		return tabla_surf;
	}
	public void setTabla_surf(boolean tabla_surf) {
		this.tabla_surf = tabla_surf;
	}
	public boolean isEsquies() {
		return esquies;
	}
	public void setEsquies(boolean esquies) {
		this.esquies = esquies;
	}
	public boolean isSeguro() {
		return seguro;
	}
	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipo_identificacion() {
		return tipo_identificacion;
	}
	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
