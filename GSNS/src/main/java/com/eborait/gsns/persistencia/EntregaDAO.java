package com.eborait.gsns.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;

/**
 * Realiza la gestión de EntregaVacunas con la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 * 
 * @see EntregaVacunas
 *
 */
public class EntregaDAO extends AbstractEntityDAO<EntregaVacunas> {
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT = "SELECT * FROM entrega_vacunas WHERE id = '%s'";
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT_CRITERIA = "SELECT * FROM entrega_vacunas";
	/**
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO entrega_vacunas VALUES('%s', '%s', '%s', %s, %s, '%s', %s)";
	/**
	 * Formato sentencia update.
	 */
	private static final String UPDATE = "UPDATE entrega_vacunas SET id = '%s', lote = '%s', fecha = '%s', cantidad = %s, prioridad = %s, tipo_vacuna = '%s', region = %s WHERE id = '%s'";
	/**
	 * Formato sentencia delete.
	 */
	private static final String DELETE = "DELETE FROM entrega_vacunas WHERE id = '%s'";

	/**
	 * Realiza una consulta a la base de datos.
	 * 
	 * @param id Identificador de EntregaVacunas que se busca.
	 * @return Un objeto EntregaVacunas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see EntregaVacunas
	 */
	@Override
	public EntregaVacunas get(String id) throws SQLException {
		Collection<Collection<Object>> data = AgenteBD.getAgente().select(String.format(SELECT, id));
		ArrayList<Object> rowData = (ArrayList<Object>) data.iterator().next();
		EntregaVacunas ev = new EntregaVacunas(String.valueOf(rowData.get(0)), String.valueOf(rowData.get(1)),
				(Date) rowData.get(2), (int) rowData.get(3), (int) rowData.get(4), String.valueOf(rowData.get(5)),
				(int) rowData.get(6));
		return ev;
	}

	/**
	 * Realiza una consulta a la base de datos. Si el argumento criteria es null
	 * devuelve todos los registros.
	 * 
	 * @param criteria Columna por la que se filtra
	 * @param value    Valor por el que se filtra.
	 * @return Una colección con los objetos EntregaVacunas encontrados.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see EntregaVacunas
	 */
	@Override
	public Collection<EntregaVacunas> getAll(String criteria, String value) throws SQLException {
		Collection<EntregaVacunas> list = new ArrayList<>();
		String sql = criteria == null ? SELECT_CRITERIA
				: String.format(SELECT_CRITERIA + " WHERE %s = %s", criteria, value);
		Collection<Collection<Object>> data = AgenteBD.getAgente().select(sql);
		for (Collection<Object> collection : data) {
			ArrayList<Object> rowData = (ArrayList<Object>) collection;
			EntregaVacunas ev = new EntregaVacunas(String.valueOf(rowData.get(0)), String.valueOf(rowData.get(1)),
					(Date) rowData.get(2), (int) rowData.get(3), (int) rowData.get(4), String.valueOf(rowData.get(5)),
					(int) rowData.get(6));
			list.add(ev);
		}
		return list;
	}

	/**
	 * Realiza una inserción en la base de datos.
	 * 
	 * @param entregaVacunas Objeto EntregaVacunas a insertar.
	 * @return El número de filas insertadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see EntregaVacunas
	 */
	@Override
	public int insert(EntregaVacunas entregaVacunas) throws SQLException {
		return AgenteBD.getAgente()
				.insert(String.format(INSERT, entregaVacunas.getId(), entregaVacunas.getLote().getId(),
						entregaVacunas.getFecha(), entregaVacunas.getCantidad(),
						entregaVacunas.getGrupoPrioridad().getPrioridad(), entregaVacunas.getTipo().toString(),
						entregaVacunas.getRegion().getId()));
	}

	/**
	 * Realiza una actualización en la base de datos.
	 * 
	 * @param entregaVacunas Objeto EntregaVacunas a actualizar.
	 * @return El número de filas actualizadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see EntregaVacunas
	 */
	@Override
	public int update(EntregaVacunas entregaVacunas) throws SQLException {
		return AgenteBD.getAgente()
				.update(String.format(UPDATE, entregaVacunas.getId(), entregaVacunas.getLote().getId(),
						entregaVacunas.getFecha(), entregaVacunas.getCantidad(),
						entregaVacunas.getGrupoPrioridad().getPrioridad(), entregaVacunas.getTipo().toString(),
						entregaVacunas.getRegion().getId(), entregaVacunas.getId()));
	}

	/**
	 * Realiza un borrado en la base de datos.
	 * 
	 * @param entregaVacunas Objeto EntregaVacunas a eliminar.
	 * @return El número de filas eliminadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see EntregaVacunas
	 */
	@Override
	public int delete(EntregaVacunas entregaVacunas) throws SQLException {
		return AgenteBD.getAgente().delete(String.format(DELETE, entregaVacunas.getId()));
	}

}