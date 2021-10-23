package com.eborait.gsns.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;

public class EntregaDAO extends AbstractEntityDAO<EntregaVacunas> {
	private static final String SELECT = "SELECT FROM entrega_vacunas WHERE id = %s";
	private static final String INSERT = "INSERT INTO entrega_vacunas VALUES(%s, %s, %s, %d, %d, %s, %d)";
	private static final String UPDATE = "UPDATE entrega_vacunas SET id = %s, lote = %s, fecha = %s, cantidad = %d, prioridad = %d, tipo_vacuna = %s, region = %d";
	private static final String DELETE = "DELETE FROM entrega_vacunas WHERE id = %s";

	@Override
	public EntregaVacunas get(String id) throws SQLException {
		ResultSet rs = AgenteBD.getAgente().select(String.format(SELECT, id));
		rs.next();
		EntregaVacunas ev = new EntregaVacunas(id, rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5),
				rs.getString(6), rs.getInt(7));
		return ev;
	}

	@Override
	public Collection<EntregaVacunas> getAll(String criteria, String value) {
		return null;
	}

	@Override
	public int insert(EntregaVacunas entregaVacunas) throws SQLException {
		return AgenteBD.getAgente()
				.insert(String.format(INSERT, entregaVacunas.getId(), entregaVacunas.getLote().getId(),
						entregaVacunas.getFecha(), entregaVacunas.getCantidad(),
						entregaVacunas.getGrupoPrioridad().getPrioridad(), entregaVacunas.getTipo().toString(),
						entregaVacunas.getRegion().getId()));
	}

	@Override
	public int update(EntregaVacunas entregaVacunas) {
		return -1;
	}

	@Override
	public int delete(EntregaVacunas entregaVacunas) throws SQLException {
		return AgenteBD.getAgente().delete(String.format(DELETE, entregaVacunas.getId()));
	}

}