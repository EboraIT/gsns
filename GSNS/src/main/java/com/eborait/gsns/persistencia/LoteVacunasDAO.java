package com.eborait.gsns.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

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
public class LoteVacunasDAO extends AbstractEntityDAO<LoteVacunas> {
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT = "SELECT * FROM lotes_vacunas WHERE id = %s";
	/**
	 * Formato sentencia select criterio.
	 */
	private static final String SELECT_CRITERIA = "SELECT * FROM lotes_vacunas";
	/**
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO lotes_vacunas VALUES(%s, %s, %s, %d, %s)";
	/**
	 * Formato sentencia update.
	 */
	private static final String UPDATE = "UPDATE lote_vacunas SET id = %s, fecha = %s, tipo = %s, cantidad = %d, farmaceutica = %s WHERE id = %s";
	/**
	 * Formato sentencia delete.
	 */
	private static final String DELETE = "DELETE FROM lotes_vacunas WHERE id = %s";

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
		ResultSet rs = AgenteBD.getAgente().select(String.format(SELECT, id));
		rs.next();
		LoteVacunas lv = new LoteVacunas(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getInt(4),
				rs.getString(5));
		return lv;
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
				: String.format(SELECT_CRITERIA + " WHERE %s = %s", criteria, value);
		ResultSet rs = AgenteBD.getAgente().select(sql);
		while (rs.next()) {
			LoteVacunas lv = new LoteVacunas(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getInt(4),
					rs.getString(5));
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
		return AgenteBD.getAgente().insert(String.format(INSERT, lote.getId(), lote.getFecha(), lote.getTipo(),
				lote.getCantidad(), lote.getFarmaceutica()));
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
		return AgenteBD.getAgente().insert(String.format(UPDATE, lote.getId(), lote.getFecha(), lote.getTipo(),
				lote.getCantidad(), lote.getFarmaceutica(), lote.getId()));
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

}