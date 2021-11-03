package com.eborait.gsns.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;

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
public class VacunacionDAO implements AbstractEntityDAO<Vacunacion> {
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT = "SELECT * FROM vacunacion WHERE id = %s";
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT_CRITERIA = "SELECT * FROM vacunacion";
	/**
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO vacunacion VALUES(%s, '%s', '%s', '%s', '%s')";
	/**
	 * Formato sentencia update.
	 */
	private static final String UPDATE = "UPDATE vacunacion SET id = %s, tipo = '%s', paciente = '%s', fecha = '%s', segunda_dosis = %s WHERE id = %s";
	/**
	 * Formato sentencia delete.
	 */
	private static final String DELETE = "DELETE FROM vacunacion WHERE id = %s";

	/**
	 * Realiza una consulta a la base de datos.
	 * 
	 * @param id Identificador de Vacunacion que se busca.
	 * @return Un objeto Vacunacion.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Vacunacion
	 */
	@Override
	public Vacunacion get(String id) throws SQLException {
		Collection<Collection<Object>> data = AgenteBD.getAgente().select(String.format(SELECT, id));
		ArrayList<Object> rowData = (ArrayList<Object>) data.iterator().next();
		return new Vacunacion((int) rowData.get(0), String.valueOf(rowData.get(1)), String.valueOf(rowData.get(2)),
				(Date) rowData.get(3), (boolean) rowData.get(4));
	}

	/**
	 * Realiza una consulta a la base de datos. Si el argumento criteria es null
	 * devuelve todos los registros.
	 * 
	 * @param criteria Columna por la que se filtra
	 * @param value    Valor por el que se filtra.
	 * @return Una colección con los objetos Vacunacion encontrados.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Vacunacion
	 */
	@Override
	public Collection<Vacunacion> getAll(String criteria, String value) throws SQLException {
		Collection<Vacunacion> list = new ArrayList<>();
		String sql = criteria == null ? SELECT_CRITERIA
				: String.format(SELECT_CRITERIA + " WHERE %s = %s", criteria, value);
		Collection<Collection<Object>> data = AgenteBD.getAgente().select(sql);
		for (Collection<Object> collection : data) {
			ArrayList<Object> rowData = (ArrayList<Object>) collection;
			Vacunacion v = new Vacunacion((int) rowData.get(0), String.valueOf(rowData.get(1)),
					String.valueOf(rowData.get(2)), (Date) rowData.get(3), (boolean) rowData.get(4));
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
		return AgenteBD.getAgente()
				.insert(String.format(INSERT, vacunacion.getId(), vacunacion.getVacuna().toString(),
						vacunacion.getPaciente().getDni(), new java.sql.Date(vacunacion.getFecha().getTime()),
						vacunacion.isSegundaDosis()));
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
						vacunacion.getPaciente().getDni(), new java.sql.Date(vacunacion.getFecha().getTime()),
						vacunacion.isSegundaDosis(), vacunacion.getId()));
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