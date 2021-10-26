package com.eborait.gsns.persistencia;

import java.sql.SQLException;
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
			// TODO cambiar TODO por el nombre del método del tipovacuna de sus atributos
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

	@Override
	public LoteVacunas get(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<LoteVacunas> getAll(String criteria, String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(LoteVacunas entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(LoteVacunas entity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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