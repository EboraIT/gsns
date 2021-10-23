package com.eborait.gsns.dominio.entitymodel;

public class Paciente {

	private RegionEnum region;
	private GrupoPrioridad grupo;
	private String dni;
	private String nombre;
	private String apellidos;

	public Paciente(String dni, String nombre, String apellidos, int grupo, int region) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.grupo = GrupoPrioridad.valueOf(grupo);
		this.region = RegionEnum.valueOf(region);
	}

	public Paciente(String fromDatabase) {
		String[] aux = fromDatabase.split(";");
		this.dni = aux[0];
		this.nombre = aux[1];
		this.apellidos = aux[2];
		this.grupo = GrupoPrioridad.valueOf(Integer.parseInt(aux[3]));
		this.region = RegionEnum.valueOf(Integer.parseInt(aux[4]));
	}

	public String toDatabase() {
		return dni + ";" + nombre + ";" + apellidos + ";" + grupo.getPrioridad() + ";" + region.getId();
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