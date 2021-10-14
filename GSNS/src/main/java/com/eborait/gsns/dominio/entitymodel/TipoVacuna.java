package com.eborait.gsns.dominio.entitymodel;

public class TipoVacuna {

	private String nombre;
	private String farmaceutica;
	private String fechaAprobacion;
	
	public TipoVacuna(String nombre, String farmaceutica, String fechaAprobacion) {
		super();
		this.nombre = nombre;
		this.farmaceutica = farmaceutica;
		this.fechaAprobacion = fechaAprobacion;
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
		return "TipoVacuna [nombre=" + nombre + ", farmaceutica=" + farmaceutica + ", fechaAprobacion="
				+ fechaAprobacion + "]";
	}

}