package com.eborait.gsns.dominio.entitymodel;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class Paciente {

	private RegionEnum region;
	private GrupoPrioridad grupo;
	private String dni;
	private String nombre;
	private String apellidos;

	public Paciente(String dni, String nombre, String apellidos, int grupo, int region) throws GSNSException {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.grupo = GrupoPrioridad.valueOf(grupo);
		this.region = RegionEnum.valueOf(region);

		this.grupo.getPacientes().add(this);
	}

	public Paciente(String dni, int grupo, int region, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		try {
			this.grupo = GrupoPrioridad.valueOf(grupo);
			this.region = RegionEnum.valueOf(region);

			this.grupo.getPacientes().add(this);
		} catch (GSNSException gsnse) {
			System.out.println(gsnse.getMessage());
			gsnse.printStackTrace();
		}
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