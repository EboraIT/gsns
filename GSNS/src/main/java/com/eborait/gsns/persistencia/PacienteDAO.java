package com.eborait.gsns.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.eborait.gsns.dominio.entitymodel.Paciente;

/**
 * Realiza la gestión de Paciente con la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 * 
 * @see Paciente
 *
 */
public class PacienteDAO implements AbstractEntityDAO<Paciente> {
	
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT = "SELECT * FROM pacientes WHERE dni = '%s'";
	
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT_CRITERIA = "SELECT * FROM pacientes";
	
	/**
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO pacientes VALUES('%s', %s, %s, '%s', '%s', '%s')";
	
	/**
	 * Formato sentencia update.
	 */
	private static final String UPDATE = "UPDATE pacientes SET dni = '%s', grupo = %s, region = %s, nombre = '%s', apellidos = '%s', segunda_dosis = %s WHERE dni = '%s'";
	
	/**
	 * Formato sentencia delete.
	 */
	private static final String DELETE = "DELETE FROM pacientes WHERE dni = '%s'";

	/**
	 * Realiza una consulta a la base de datos.
	 * 
	 * @param id Identificador de Paciente que se busca.
	 * @return Un objeto Paciente.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Paciente
	 */
	@Override
	public Paciente get(String id) throws SQLException {
		Collection<Collection<Object>> data = AgenteBD.getAgente().select(String.format(SELECT, id));
		Iterator<Collection<Object>> it = data.iterator();
		if (it.hasNext()) {
			ArrayList<Object> rowData = (ArrayList<Object>) it.next();
			return new Paciente(String.valueOf(rowData.get(0)), (int) rowData.get(1), (int) rowData.get(2),
					String.valueOf(rowData.get(3)), String.valueOf(rowData.get(4)), (boolean) rowData.get(5));
		}
		return null;
	}

	/**
	 * Realiza una consulta a la base de datos. Si el argumento criteria es null
	 * devuelve todos los registros.
	 * 
	 * @param criteria Columna por la que se filtra
	 * @param value    Valor por el que se filtra.
	 * @return Una colección con los objetos Paciente encontrados.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Paciente
	 */
	@Override
	public Collection<Paciente> getAll(String criteria, String value) throws SQLException {
		Collection<Paciente> list = new ArrayList<>();
		String sql = criteria == null ? SELECT_CRITERIA
				: String.format(SELECT_CRITERIA + " WHERE %s = %s", criteria, value);
		Collection<Collection<Object>> data = AgenteBD.getAgente().select(sql);
		for (Collection<Object> collection : data) {
			ArrayList<Object> rowData = (ArrayList<Object>) collection;
			Paciente p = new Paciente(String.valueOf(rowData.get(0)), (int) rowData.get(1), (int) rowData.get(2),
					String.valueOf(rowData.get(3)), String.valueOf(rowData.get(4)), (boolean) rowData.get(5));
			list.add(p);
		}
		return list;
	}

	/**
	 * Realiza una inserción en la base de datos.
	 * 
	 * @param paciente Objeto Paciente a insertar.
	 * @return El número de filas insertadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Paciente
	 */
	@Override
	public int insert(Paciente paciente) throws SQLException {
		return AgenteBD.getAgente()
				.insert(String.format(INSERT, paciente.getDni(), paciente.getGrupo().getPrioridad(),
						paciente.getRegion().getId(), paciente.getNombre(), paciente.getApellidos(),
						paciente.isSegundaDosis()));
	}

	/**
	 * Realiza una actualización en la base de datos.
	 * 
	 * @param paciente Objeto Paciente a actualizar.
	 * @return El número de filas actualizadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Paciente
	 */
	@Override
	public int update(Paciente paciente) throws SQLException {
		return AgenteBD.getAgente()
				.update(String.format(UPDATE, paciente.getDni(), paciente.getGrupo().getPrioridad(),
						paciente.getRegion().getId(), paciente.getNombre(), paciente.getApellidos(),
						paciente.isSegundaDosis(), paciente.getDni()));
	}

	/**
	 * Realiza un borrado en la base de datos.
	 * 
	 * @param paciente Objeto Paciente a eliminar.
	 * @return El número de filas eliminadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Paciente
	 */
	@Override
	public int delete(Paciente paciente) throws SQLException {
		return AgenteBD.getAgente().delete(String.format(DELETE, paciente.getDni()));
	}

}