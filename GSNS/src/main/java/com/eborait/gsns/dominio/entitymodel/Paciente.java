package com.eborait.gsns.dominio.entitymodel;

public class Paciente {

	RegionEnum region;
	GrupoPrioridad grupo;
	private String dni;
	private String nombre;
	private String apellidos;
	
	public Paciente(RegionEnum region, GrupoPrioridad grupo, String dni, String nombre, String apellidos) {
		super();
		this.region = region;
		this.grupo = grupo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public RegionEnum getRegion() {
		return region;
	}
	public void setRegion(RegionEnum region) {
		this.region = region;
	}
	public GrupoPrioridad getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoPrioridad grupo) {
		this.grupo = grupo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	@Override
	public String toString() {
		return "Paciente [region=" + region + ", grupo=" + grupo + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + "]";
	}

}