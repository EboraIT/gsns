package com.eborait.gsns.dominio.entitymodel;

public class TipoVacuna {

	private String nombre;
	private String farmaceutica;
	private String fechaAprobacion;

	public TipoVacuna(String nombre, String farmaceutica, String fechaAprobacion) {
		this.nombre = nombre;
		this.farmaceutica = farmaceutica;
		this.fechaAprobacion = fechaAprobacion;
	}

	public TipoVacuna(String tipo) {
		this.nombre = tipo.substring(0, tipo.indexOf("-"));
		this.farmaceutica = tipo.substring(tipo.indexOf("-") + 1, tipo.lastIndexOf("-"));
		this.fechaAprobacion = tipo.substring(tipo.lastIndexOf("-") + 1);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}

	public String getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	@Override
	public String toString() {
		return nombre + "-" + farmaceutica + "-" + fechaAprobacion;
	}

}