package com.eborait.gsns.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;

/**
 * Realiza la gestión de Vacunacion con la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 * 
 * @see Vacunacion
 *
 */
public class VacunacionDAO extends AbstractEntityDAO<Vacunacion> {
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT = "SELECT FROM vacunacion WHERE id = %s";
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT_CRITERIA = "SELECT FROM vacunacion WHERE %s = %s";
	/**
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO vacunacion VALUES(%d, %s, %s, %s, %s)";
	/**
	 * Formato sentencia update.
	 */
	private static final String UPDATE = "UPDATE vacunacion SET id = %s, tipo = %s, paciente = %s, fecha = %s, segundaDosis = %s WHERE id = %s";
	/**
	 * Formato sentencia delete.
	 */
	private static final String DELETE = "DELETE FROM vacunacion WHERE id = %s";

	@Override
	public Vacunacion get(String id) throws SQLException {
		ResultSet rs = AgenteBD.getAgente().select(String.format(SELECT, id));
		rs.next();
		Vacunacion v = new Vacunacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getBoolean(5));
		return v;
	}

	@Override
	public Collection<Vacunacion> getAll(String criteria, String value) throws SQLException {
		Collection<Vacunacion> list = new ArrayList<>();
		ResultSet rs = AgenteBD.getAgente().select(String.format(SELECT_CRITERIA, criteria, value));
		while (rs.next()) {
			Vacunacion v = new Vacunacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
					rs.getBoolean(5));
			list.add(v);
		}
		return list;
	}

	/**
	 * Realiza una inserción en la base de datos.
	 * 
	 * @param vacunacion objeto Vacunacion a insertar.
	 * @return El número de filas insertadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Vacunacion
	 */
	@Override
	public int insert(Vacunacion vacunacion) throws SQLException {
		return AgenteBD.getAgente().insert(String.format(INSERT, vacunacion.getId(), vacunacion.getVacuna().toString(),
				vacunacion.getPaciente().toDatabase(), vacunacion.getFecha(), vacunacion.isSegundaDosis()));
	}

	/**
	 * Realiza una actualización en la base de datos.
	 * 
	 * @param vacunacion objeto Vacunacion a actualizar.
	 * @return El número de filas actualizadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Vacunacion
	 */
	@Override
	public int update(Vacunacion vacunacion) throws SQLException {
		return AgenteBD.getAgente()
				.update(String.format(UPDATE, vacunacion.getId(), vacunacion.getVacuna().toString(),
						vacunacion.getPaciente().toDatabase(), vacunacion.getFecha(), vacunacion.isSegundaDosis(),
						vacunacion.getId()));
	}

	/**
	 * Realiza un borrado en la base de datos.
	 * 
	 * @param vacunacion objeto Vacunacion a eliminar.
	 * @return El número de filas eliminadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Vacunacion
	 */
	@Override
	public int delete(Vacunacion vacunacion) throws SQLException {
		return AgenteBD.getAgente().delete(String.format(DELETE, vacunacion.getId()));
	}

}