package com.eborait.gsns.dominio.entitymodel;

/**
 * Define la información relativa a una entrega de vacunas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class TipoVacuna {

	/** El nombre. */
	private String nombre;

	/** La farmacéutica. */
	private String farmaceutica;

	/** La fecha de aprobación. */
	private String fechaAprobacion;

	/**
	 * Instancia un nuevo tipo de vacuna.
	 *
	 * @param nombre          El nombre.
	 * @param farmaceutica    La farmacéutica.
	 * @param fechaAprobacion La fecha de aprobación.
	 */
	public TipoVacuna(String nombre, String farmaceutica, String fechaAprobacion) {
		this.nombre = nombre;
		this.farmaceutica = farmaceutica;
		this.fechaAprobacion = fechaAprobacion;
	}

	/**
	 * Instancia un nuevo tipo de vacuna.
	 *
	 * @param tipo El tipo de vacuna.
	 */
	public TipoVacuna(String tipo) {
		this.nombre = tipo.substring(0, tipo.indexOf("-"));
		this.farmaceutica = tipo.substring(tipo.indexOf("-") + 1, tipo.lastIndexOf("-"));
		this.fechaAprobacion = tipo.substring(tipo.lastIndexOf("-") + 1);
	}

	/**
	 * Se obtiene el nombre.
	 *
	 * @return El nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre.
	 *
	 * @param nombre El nuevo nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Se obtiene la farmacéutica.
	 *
	 * @return La farmacéutica
	 */
	public String getFarmaceutica() {
		return farmaceutica;
	}

	/**
	 * Establece la farmacéutica.
	 *
	 * @param farmaceutica La nueva farmacéutica.
	 */
	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}

	/**
	 * Se obtiene la fecha de aprobación.
	 *
	 * @return La fecha de aprobación
	 */
	public String getFechaAprobacion() {
		return fechaAprobacion;
	}

	/**
	 * Establece la fecha de aprobación.
	 *
	 * @param fechaAprobacion La nueva fecha de aprobación.
	 */
	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	/**
	 * Transforma la clase TipoVacuna a String.
	 *
	 * @return La clase TipoVacuna como String.
	 */
	@Override
	public String toString() {
		return nombre + "-" + farmaceutica + "-" + fechaAprobacion;
	}

}