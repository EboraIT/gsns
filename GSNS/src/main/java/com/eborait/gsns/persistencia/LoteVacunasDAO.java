package com.eborait.gsns.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.LoteVacunas;

public class LoteVacunasDAO extends AbstractEntityDAO<LoteVacunas> {
	/*
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO lotes_vacunas VALUES(%s, %s, %s, %s)";
	/*
	 * Formato sentencia delete.
	 */
	private static final String DELETE = "DELETE FROM lotes_vacunas WHERE id = %s";
	/*
	 * Formato sentencia select.
	 */
	private static final String SELECT = "SELECT FROM lotes_vacunas WHERE id = %s";
	/*
	 * Formato sentencia select criterio.
	 */
	private static final String SELECT_CRITERIA = "SELECT FROM lotes_vacunas WHERE %s = %s";
	/*
	 * Formato sentencia update.
	 */
	private static final String UPDATE = "UPDATE lote_vacunas SET fecha = %s, cantidad =%d,farmaceutica =%s where id=%s";
	/**
	 * 
	 * @param lote
	 * @return 
	 */
	public static int insertarLoteVacunas(LoteVacunas lote) throws SQLException{
		try {
			// TODO cambiar TODO por el nombre del mÃ©todo del tipovacuna de sus atributos
			// combinados
			return AgenteBD.getAgente()
					.insert(String.format(INSERT, lote.getId(), lote.getFecha(),
							lote.getCantidad(), lote.getFarmaceutica()));
		} catch (SQLException sqle) {
			System.out.println("Excepcionn insertando el lote vacunas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw sqle;
		}
	}
	/*
	 * Realiza consulta a la base de datos.
	 * 
	 * @param id identificador de lote vacunas que se va a buscar
	 * @return Un objeto LoteVacunas
	 * @throws SQLException Si se produce una excepción en la setencia SQL
	 * @see LoteVacunas
	 */

	@Override
	public LoteVacunas get(String id) throws SQLException {
		ResultSet rs = AgenteBD.getAgente().select(String.format(SELECT, id));
		rs.next();
		LoteVacunas lv = new LoteVacunas(rs.getString(1),rs.getDate(2),rs.getString(4),rs.getInt(3));
		return lv;
	}

	/*
	 * Realiza consulta a la base de datos.
	 * 
	 * @param criteria Columna para filtrar
	 * @param value valor por el que se filtra
	 * @return Una coleccion con los objetos de LoteVacunas encontrados
	 * @throws SQLException Si se produce una excepción en la setencia SQL
	 * @see LoteVacunas
	 */
	
	@Override
	public Collection<LoteVacunas> getAll(String criteria, String value) throws SQLException {
		Collection<LoteVacunas> list = new ArrayList<>();
		ResultSet rs = AgenteBD.getAgente().select(String.format(SELECT_CRITERIA, criteria,value));
		while(rs.next()) {
			LoteVacunas lv = new LoteVacunas (rs.getString(1),rs.getDate(2),rs.getString(4),rs.getInt(3));
			list.add(lv);
		}
		return list;
	}

	/*
	 * Realiza inserción a la base de datos.
	 * 
	 * @param entity objeto de la clase LoteVacunas
	 * @return El numero de filas insertadas
	 * @throws SQLException Si se produce una excepción en la setencia SQL
	 * @see LoteVacunas
	 */
	public int insert(LoteVacunas entity) throws SQLException {
		return AgenteBD.getAgente().insert(String.format(INSERT,entity.getId(),entity.getFecha(),entity.getCantidad(),entity.getFarmaceutica()));
		}

	/*
	 * Realiza una actualizacion a la base de datos.
	 * 
	 * @param entity objeto de la clase LoteVacunas
	 * @return El numero de filas actualizadas
	 * @throws SQLException Si se produce una excepción en la setencia SQL
	 * @see LoteVacunas
	 */
	public int update(LoteVacunas entity) throws SQLException {
		return AgenteBD.getAgente()
				.insert(String.format(UPDATE, entity.getFecha(),entity.getCantidad(),entity.getFarmaceutica()));
	}

	@Override
	public int delete(LoteVacunas lote) throws SQLException {
		try {
			return AgenteBD.getAgente().delete(String.format(DELETE, lote.getId()));
		} catch (SQLException sqle) {
			System.out.println("Excepcion borrado lote vacunas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw sqle;
		}
	}

}