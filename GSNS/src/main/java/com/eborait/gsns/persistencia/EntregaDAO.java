package com.eborait.gsns.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;

public class EntregaDAO extends AbstractEntityDAO<EntregaVacunas> {
	private static final String INSERT = "INSERT INTO entrega_vacunas VALUES(%s, %s, %s, %s, %s, %s, %s)";

	@Override
	public EntregaVacunas get(String id) {
		return null;
	}

	@Override
	public Collection<EntregaVacunas> getAll(String criteria, String value) {
		return null;
	}

	@Override
	public int insert(EntregaVacunas entregaVacunas) throws SQLException {
		try {
			// TODO cambiar TODO por el nombre del método del tipovacuna de sus atributos
			// combinados
			return AgenteBD.getAgente()
					.insert(String.format(INSERT, entregaVacunas.getId(), entregaVacunas.getFecha(),
							entregaVacunas.getCantidad(), entregaVacunas.getLote().getId(),
							entregaVacunas.getGrupoPrioridad().getPrioridad(), entregaVacunas.getTipo().TODO(),
							entregaVacunas.getRegion().getId()));
		} catch (SQLException sqle) {
			System.out.println("Excepción insertando entrega:\n\n" + sqle.getStackTrace());
			throw sqle;
		}
	}

	@Override
	public int update(EntregaVacunas entregaVacunas) {
		return -1;
	}

	@Override
	public int delete(EntregaVacunas entregaVacunas) {
		return -1;
	}

}