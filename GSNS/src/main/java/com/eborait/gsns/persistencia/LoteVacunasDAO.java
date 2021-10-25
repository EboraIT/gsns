package com.eborait.gsns.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.LoteVacunas;

public class LoteVacunasDAO extends AbstractEntityDAO<LoteVacunas> {
	private static final String INSERT = "INSERT INTO lotes_vacunas VALUES(%s, %s, %s, %s)";
	private static final String DELETE = "DELETE FROM lotes_vacunas WHERE id = %s";
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
					.insert(String.format(INSERT, LoteVacunas.getId(), LoteVacunas.getFecha(),
							LoteVacunas.getCantidad(), LoteVacunas.getFarmaceutica()));
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
	public int delete(LoteVacunas entity) throws SQLException {
		try {
			return AgenteBD.getAgente().delete(String.format(DELETE, LoteVacunas.getId()));
		} catch (SQLException sqle) {
			System.out.println("Excepcion borrado lote vacunas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw sqle;
		}
	}

}