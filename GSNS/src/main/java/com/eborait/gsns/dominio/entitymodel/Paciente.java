package com.eborait.gsns.dominio.entitymodel;

import com.eborait.gsns.dominio.controller.Util;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Define la información relativa a un paciente.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class Paciente {
	
	/** Objeto Logger. */
	private static final Logger LOG = Logger.getLogger(Paciente.class.getName());


	/** La region. */
	private RegionEnum region;

	/** El grupo. */
	private GrupoPrioridad grupo;

	/** El dni. */
	private String dni;

	/** El nombre. */
	private String nombre;

	/** Los apellidos. */
	private String apellidos;

	/** La segunda dosis. */
	private boolean segundaDosis;

	/**
	 * Instancia un nuevo paciente.
	 *
	 * @param dni       El dni.
	 * @param nombre    El nombre.
	 * @param apellidos Los apellidos.
	 * @param grupo     El grupo.
	 * @param region    La region.
	 * @param segundaDosis La segunda dosis.
	 * @throws GSNSException Si se produce una excepción en el grupo de prioridad o
	 *                       la región.
	 */
	public Paciente(String dni, String nombre, String apellidos, int grupo, int region, boolean segundaDosis) throws GSNSException {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.grupo = GrupoPrioridad.valueOf(grupo);
		this.region = RegionEnum.valueOf(region);
		this.segundaDosis = segundaDosis;

		this.grupo.getPacientes().add(this);
	}

	/**
	 * Instancia un nuevo paciente.
	 *
	 * @param dni       El dni.
	 * @param grupo     El grupo.
	 * @param region    La region.
	 * @param nombre    El nombre.
	 * @param apellidos Los apellidos.
	 * @param segundaDosis La segunda dosis.
	 */
	public Paciente(String dni, int grupo, int region, String nombre, String apellidos, boolean segundaDosis) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.segundaDosis = segundaDosis;
		try {
			this.grupo = GrupoPrioridad.valueOf(grupo);
			this.region = RegionEnum.valueOf(region);

			this.grupo.getPacientes().add(this);
		} catch (GSNSException gsnse) {
			LOG.log(Level.SEVERE, "{0}", "" + gsnse.getMessage());
			LOG.log(Level.SEVERE, "", gsnse);
		}
	}

	/**
	 * Se obtiene la región.
	 *
	 * @return La región.
	 */
	public RegionEnum getRegion() {
		return region;
	}

	/**
	 * Establece la región.
	 *
	 * @param region La nueva región.
	 */
	public void setRegion(RegionEnum region) {
		this.region = region;
	}

	/**
	 * Se obtiene el grupo de prioridad.
	 *
	 * @return El grupo de prioridad.
	 */
	public GrupoPrioridad getGrupo() {
		return grupo;
	}

	/**
	 * Establece el grupo de prioridad.
	 *
	 * @param grupo El nuevo grupo de prioridad.
	 */
	public void setGrupo(GrupoPrioridad grupo) {
		this.grupo = grupo;
	}

	/**
	 * Se obtiene el dni.
	 *
	 * @return El dni.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el dni.
	 *
	 * @param dni El nuevo dni.
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
	 * Se obtienen los apellidos.
	 *
	 * @return Los apellidos.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece los apellidos.
	 *
	 * @param apellidos Los nuevos apellidos.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * Comprueba si es la segunda dosis.
	 *
	 * @return Verdadero, si es la segunda dosis.
	 */
	public boolean isSegundaDosis() {
		return segundaDosis;
	}

	/**
	 * Establece si es segunda dosis.
	 *
	 * @param segundaDosis Si es la segunda dosis.
	 */
	public void setSegundaDosis(boolean segundaDosis) {
		this.segundaDosis = segundaDosis;
	}

}