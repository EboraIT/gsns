package com.eborait.gsns.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;

import com.eborait.gsns.dominio.entitymodel.LoteVacunas;

/**
 * Realiza la gestión de LoteVacunas con la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 * 
 * @see LoteVacunas
 *
 */
public class LoteVacunasDAO implements AbstractEntityDAO<LoteVacunas> {

	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT = "SELECT * FROM lote_vacunas WHERE id = '%s'";

	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT_CRITERIA = "SELECT * FROM lote_vacunas";

	/**
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO lote_vacunas VALUES('%s', '%s', '%s', %s, '%s')";

	/**
	 * Formato sentencia update.
	 */
	private static final String UPDATE = "UPDATE lote_vacunas SET id = '%s', fecha = '%s', tipo = '%s', cantidad = %s, farmaceutica = '%s' WHERE id = '%s'";

	/**
	 * Formato sentencia delete.
	 */
	private static final String DELETE = "DELETE FROM lote_vacunas WHERE id = '%s'";

	/**
	 * Realiza una consulta a la base de datos.
	 * 
	 * @param id Identificador de LoteVacunas que se va a buscar.
	 * @return Un objeto LoteVacunas.
	 * @throws SQLException Si se produce una excepción en la setencia SQL.
	 * @see LoteVacunas
	 */
	@Override
	public LoteVacunas get(String id) throws SQLException {
		Collection<Collection<Object>> data = AgenteBD.getAgente().select(String.format(SELECT, id));
		ArrayList<Object> rowData = (ArrayList<Object>) data.iterator().next();
		return new LoteVacunas(String.valueOf(rowData.get(0)), (Date) rowData.get(1), String.valueOf(rowData.get(2)),
				(int) rowData.get(3), String.valueOf(rowData.get(4)));
	}

	/**
	 * Realiza una consulta a la base de datos. Si el argumento criteria es null
	 * devuelve todos los registros.
	 * 
	 * @param criteria Columna para filtrar.
	 * @param value    Valor por el que se filtra.
	 * @return Una colección con los objetos LoteVacunas encontrados.
	 * @throws SQLException Si se produce una excepción en la setencia SQL.
	 * @see LoteVacunas
	 */
	@Override
	public Collection<LoteVacunas> getAll(String criteria, String value) throws SQLException {
		Collection<LoteVacunas> list = new ArrayList<>();
		String sql = criteria == null ? SELECT_CRITERIA
				: String.format(SELECT_CRITERIA + " WHERE %s = '%s'", criteria, value);
		Collection<Collection<Object>> data = AgenteBD.getAgente().select(sql);
		for (Collection<Object> collection : data) {
			ArrayList<Object> rowData = (ArrayList<Object>) collection;
			LoteVacunas lv = new LoteVacunas(String.valueOf(rowData.get(0)), (Date) rowData.get(1),
					String.valueOf(rowData.get(2)), (int) rowData.get(3), String.valueOf(rowData.get(4)));
			list.add(lv);
		}
		return list;
	}

	/**
	 * Realiza una inserción en la base de datos.
	 * 
	 * @param lote Objeto de la clase LoteVacunas.
	 * @return El número de filas insertadas.
	 * @throws SQLException Si se produce una excepción en la setencia SQL.
	 * @see LoteVacunas
	 */
	@Override
	public int insert(LoteVacunas lote) throws SQLException {
		return AgenteBD.getAgente()
				.insert(String.format(INSERT, lote.getId(), new java.sql.Date(lote.getFecha().getTime()),
						lote.getTipo(), lote.getCantidad(), lote.getFarmaceutica()));
	}

	/**
	 * Realiza una actualización en la base de datos.
	 * 
	 * @param lote Objeto de la clase LoteVacunas.
	 * @return El número de filas actualizadas.
	 * @throws SQLException Si se produce una excepción en la setencia SQL.
	 * @see LoteVacunas
	 */
	@Override
	public int update(LoteVacunas lote) throws SQLException {
		return AgenteBD.getAgente()
				.insert(String.format(UPDATE, lote.getId(), new java.sql.Date(lote.getFecha().getTime()),
						lote.getTipo(), lote.getCantidad(), lote.getFarmaceutica(), lote.getId()));
	}

	/**
	 * Realiza un borrado en la base de datos.
	 * 
	 * @param lote Objeto de la clase LoteVacunas.
	 * @return El número de filas eliminadas.
	 * @throws SQLException Si se produce una excepción en la setencia SQL.
	 * @see LoteVacunas
	 */
	@Override
	public int delete(LoteVacunas lote) throws SQLException {
		return AgenteBD.getAgente().delete(String.format(DELETE, lote.getId()));
	}

	/**
	 * Consulta el valor máximo de una columna.
	 * 
	 * @param criteria Columna para filtrar.
	 * @return El valor máximo de la columna por la que se filtra la consulta.
	 * @throws SQLException Si se produce una excepción en la setencia SQL.
	 */
	public int max(String criteria) throws SQLException {
		int max = 0;
		Collection<Collection<Object>> data = AgenteBD.getAgente()
				.select(String.format("SELECT coalesce(max(%s), 0) FROM lote_vacunas", criteria));
		for (Collection<Object> collection : data) {
			ArrayList<Object> rowData = (ArrayList<Object>) collection;
			max = Integer.parseInt(rowData.get(0).toString());
		}
		return max;
	}

}