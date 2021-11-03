package com.eborait.gsns.dominio.entitymodel;

import java.util.ArrayList;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Define la información relativa a grupos de prioridad.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public enum GrupoPrioridad {

	/** Ancianos en residencias. */
	RESIDENTE_ANCIANO(1, "Ancianos en residencias"),
	/** Personal sanitario. */
	SANITARIO(2, "Personal sanitario"),
	/** Trabajadores esenciales. */
	TRABAJADOR_ESENCIAL(3, "Trabajadores esenciales"),
	/** Ancianos. */
	ANCIANO(4, "Ancianos"),
	/** Adultos. */
	ADULTO(5, "Adultos"),
	/** Jóvenes. */
	JOVEN(6, "Jóvenes"),
	/** Niños. */
	NINO(7, "Niños");

	/** Los pacientes. */
	private Collection<Paciente> pacientes;

	/** Las entregas. */
	private Collection<EntregaVacunas> entregas;

	/** La prioridad. */
	private final int prioridad;

	/** El nombre. */
	private final String nombre;

	/**
	 * Instancia un nuevo grupo de prioridad.
	 *
	 * @param prioridad La prioridad.
	 * @param nombre    El nombre.
	 */
	private GrupoPrioridad(int prioridad, String nombre) {
		this.prioridad = prioridad;
		this.nombre = nombre;
		this.entregas = new ArrayList<>();
		this.pacientes = new ArrayList<>();
	}

	/**
	 * Se obtienen los pacientes.
	 *
	 * @return Los pacientes.
	 */
	public Collection<Paciente> getPacientes() {
		return pacientes;
	}

	/**
	 * Establece los pacientes.
	 *
	 * @param pacientes Los nuevos pacientes.
	 */
	public void setPacientes(Collection<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	/**
	 * Se obtienen las entregas.
	 *
	 * @return Las entregas.
	 */
	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	/**
	 * Establece las entregas.
	 *
	 * @param entregas Las nuevas entregas.
	 */
	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
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
	 * Se obtiene la prioridad.
	 *
	 * @return La prioridad.
	 */
	public int getPrioridad() {
		return prioridad;
	}

	/**
	 * Busca un grupo por la prioridad.
	 *
	 * @param prioridad La prioridad.
	 * @return El grupo de prioridad.
	 * @throws GSNSException Si la prioridad no existe.
	 */
	public static GrupoPrioridad valueOf(int prioridad) throws GSNSException {
		for (GrupoPrioridad gp : values()) {
			if (gp.getPrioridad() == prioridad) {
				return gp;
			}
		}
		throw new GSNSException("El grupo de prioridad no existe.");
	}

	/**
	 * Se obtienen los nombres de los grupos de prioridad.
	 *
	 * @return Los nombres de los grupos de prioridad.
	 */
	public static String[] getNombres() {
		String[] nombres = new String[values().length];
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = values()[i].getNombre();
		}
		return nombres;
	}

}