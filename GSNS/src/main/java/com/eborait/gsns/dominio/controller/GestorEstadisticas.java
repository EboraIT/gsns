package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
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
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunados() throws GSNSException {
		try {
			return DAOFactory.getVacunacionDAO().getAll(null,null).size();
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException("Se ha producido un error al consultar el número total de vacunados.");
		}
	}

	/**
	 * Consulta el número total de vacunados de una región.
	 * 
	 * @param region La región por la que se filtra la consulta.
	 * @return El número total de vacunados de la región.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunadosPorRegion(RegionEnum region) throws GSNSException {
		try {
			int contador = 0;
			Collection<Vacunacion> vacunaciones = DAOFactory.getVacunacionDAO().getAll(null,null);
			for (Vacunacion vacunacion : vacunaciones) {
				if (vacunacion.getPaciente().getRegion() == region) {
					contador++;
				}
			}
			return contador;
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException("Se ha producido un error al consultar el número total de vacunados por región.");
		}
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibidas.
	 * 
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarPorcentajeVacunadosSobreRecibidas() throws GSNSException {
		try {
			int totalVacunados = consultarTotalVacunados();
			int vacunasRecibidas = 0;
			Collection<LoteVacunas> lotes = DAOFactory.getLoteVacunasDAO().getAll(null,null);
			for (LoteVacunas loteVacunas : lotes) {
				vacunasRecibidas += loteVacunas.getCantidad();
			}
			return (totalVacunados / vacunasRecibidas) * 100;
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException("Se ha producido un error al consultar el porcentaje de vacunados.");
		}
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibidas de una región.
	 * 
	 * @param region La región por la que se filtra la consulta.
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas de la región.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum region) throws GSNSException {
		try {
			int totalVacunados = consultarTotalVacunadosPorRegion(region);
			int vacunasRecibidas = 0;
			Collection<EntregaVacunas> entregas = DAOFactory.getEntregaDAO().getAll(null,null);
			for (EntregaVacunas entrega : entregas) {
				if (entrega.getRegion() == region) {
					vacunasRecibidas += entrega.getLote().getCantidad();
				}
			}
			return (totalVacunados / vacunasRecibidas) * 100;
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException("Se ha producido un error al consultar el porcentaje de vacunados por región.");
		}
	}

}