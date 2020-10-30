package com.miw.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class DatosPago {

	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellidos;
	@NotEmpty
	private String tipo_identificacion;
	@NotEmpty
	private String identificacion;
	@NotEmpty
	@Email
	private String email;
	

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
