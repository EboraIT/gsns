package com.eborait.gsns.dominio.entitymodel;

import java.sql.SQLException;
import java.util.Date;

import com.eborait.gsns.persistencia.DAOFactory;

/**
 * Define la información relativa a una entrega de vacunas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class Vacunacion {

	/** El id. */
	private int id;

	/** El tipo de vacuna. */
	private TipoVacuna vacuna;

	/** El paciente. */
	private Paciente paciente;

	/** La fecha. */
	private Date fecha;

	/** La segunda dosis. */
	private boolean segundaDosis;

	/**
	 * Instancia una nueva vacunación.
	 *
	 * @param id           El id.
	 * @param vacuna       El tipo de vacuna.
	 * @param paciente     El paciente.
	 * @param fecha        La fecha.
	 * @param segundaDosis La segunda dosis.
	 */
	public Vacunacion(int id, TipoVacuna vacuna, Paciente paciente, Date fecha, boolean segundaDosis) {
		this.id = id;
		this.vacuna = vacuna;
		this.paciente = paciente;
		this.fecha = fecha;
		this.segundaDosis = segundaDosis;
	}

	/**
	 * Instancia una nueva vacunación.
	 *
	 * @param id           El id.
	 * @param vacuna       El tipo de vacuna.
	 * @param paciente     El paciente.
	 * @param fecha        La fecha.
	 * @param segundaDosis La segunda dosis.
	 * @throws SQLException Si se produce algún al buscar el paciente en la base de
	 *                      datos.
	 */
	public Vacunacion(int id, String vacuna, String paciente, Date fecha, boolean segundaDosis) throws SQLException {
		this(id, new TipoVacuna(vacuna), DAOFactory.getPacienteDAO().get(paciente), fecha, segundaDosis);
	}

	/**
	 * Se obtiene el id.
	 *
	 * @return El id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el id.
	 *
	 * @param id El nuevo id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Se obtiene el tipo de vacuna.
	 *
	 * @return El tipo de vacuna.
	 */
	public TipoVacuna getVacuna() {
		return vacuna;
	}

	/**
	 * Establece el tipo de vacuna.
	 *
	 * @param vacuna El nuevo tipo de vacuna.
	 */
	public void setVacuna(TipoVacuna vacuna) {
		this.vacuna = vacuna;
	}

	/**
	 * Se obtiene el paciente.
	 *
	 * @return El paciente.
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * Establece el paciente.
	 *
	 * @param paciente El nuevo paciente.
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * Se obtiene la fecha.
	 *
	 * @return La fecha.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha.
	 *
	 * @param fecha La nueva fecha.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	@Override
	public boolean equals(Object obj) {
		Vacunacion v = (Vacunacion) obj;
		if (v != null) {
			return vacuna.equals(v.getVacuna()) && paciente.equals(v.getPaciente())
					&& segundaDosis == v.isSegundaDosis();
		} else {
			return false;
		}
	}

}