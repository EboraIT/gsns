package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;
import com.eborait.gsns.persistencia.DAOFactory;

/**
 * Realiza la gestión de estadísticas.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 *
 */
public class GestorEstadisticas {

	/**
	 * Consulta el número total de vacunados.
	 * 
	 * @return El número total de vacunados.
	 * @throws Exception Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunados() throws Exception {
		return DAOFactory.getVacunacionDAO().getAll(" ", " ").size();
	}

	/**
	 * Consulta el número total de vacunados de una región.
	 * 
	 * @param region La región por la que se filtra la consulta.
	 * @return El número total de vacunados de la región.
	 * @throws SQLException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunadosPorRegion(RegionEnum region) throws SQLException {
		int contador = 0;
		Collection<Vacunacion> vacunaciones = DAOFactory.getVacunacionDAO().getAll(" ", " ");
		for (Vacunacion vacunacion : vacunaciones) {
			if (vacunacion.getPaciente().getRegion() == region) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibidas.
	 * 
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas.
	 * @throws Exception Si se produce una excepción al consultar.
	 */
	public int consultarPorcentajeVacunadosSobreRecibidas() throws Exception {
		int totalVacunados = consultarTotalVacunados();
		int vacunasRecibidas = 0;
		Collection<LoteVacunas> lotes = DAOFactory.getLoteVacunasDAO().getAll(" ", " ");
		for (LoteVacunas loteVacunas : lotes) {
			vacunasRecibidas += loteVacunas.getCantidad();
		}
		return (totalVacunados / vacunasRecibidas) * 100;
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibidas de una región.
	 * 
	 * @param region La región por la que se filtra la consulta.
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas de la región.
	 * @throws SQLException Si se produce una excepción al consultar.
	 */
	public int consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum region) throws Exception {
		int totalVacunados = consultarTotalVacunadosPorRegion(region);
		int vacunasRecibidas = 0;
		Collection<EntregaVacunas> entregas = DAOFactory.getEntregaDAO().getAll(" ", " ");
		for (EntregaVacunas entrega : entregas) {
			if (entrega.getRegion() == region) {
				vacunasRecibidas += entrega.getLote().getCantidad();
			}
		}
		return (totalVacunados / vacunasRecibidas) * 100;
	}

}