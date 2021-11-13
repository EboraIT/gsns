package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

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

	/** El gestor de la aplicación. */
	private GestorGSNS gestorGSNS;
	
	/** Se crea constante para segunda_dosis. **/
	private static final String SEGUNDA_DOSIS="segunda_dosis";

	/**
	 * Instancia un nuevo GestorEstadisticas.
	 * 
	 * @param gestorGSNS El gestor de la aplicación.
	 */
	public GestorEstadisticas(GestorGSNS gestorGSNS) {
		this.gestorGSNS = gestorGSNS;
	}

	/**
	 * Consulta el número total de vacunados.
	 * 
	 * @return El número total de vacunados con la primera dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunadosPrimeraDosis() throws GSNSException {
		try {
			return gestorGSNS.getVacunacionDAO().getAll(SEGUNDA_DOSIS, "false").size();
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException(
					"Se ha producido un error al consultar el número total de vacunados con la primera dosis.");
		}
	}

	/**
	 * Consulta el número total de vacunados segunda dosis.
	 * 
	 * @return El número total de vacunados con la segunda dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunadosSegundaDosis() throws GSNSException {
		try {
			return gestorGSNS.getVacunacionDAO().getAll(SEGUNDA_DOSIS, "true").size();
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException(
					"Se ha producido un error al consultar el número total de vacunados con la segunda dosis.");
		}
	}

	/**
	 * Consulta el número total de vacunados de una región con primera dosis.
	 * 
	 * @param region La región por la que se filtra la consulta.
	 * @return El número total de vacunados de la región con la primera dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunadosPorRegionPrimeraDosis(int region) throws GSNSException {
		try {
			int contador = 0;
			Collection<Vacunacion> vacunaciones = gestorGSNS.getVacunacionDAO().getAll(SEGUNDA_DOSIS, "false");
			for (Vacunacion vacunacion : vacunaciones) {
				if (vacunacion.getPaciente().getRegion().getId() == region) {
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
	 * Consulta el número total de vacunados de una región con segunda dosis.
	 * 
	 * @param region La región por la que se filtra la consulta.
	 * @return El número total de vacunados de la región con la segunda dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunadosPorRegionSegundaDosis(int region) throws GSNSException {
		try {
			int contador = 0;
			Collection<Vacunacion> vacunaciones = gestorGSNS.getVacunacionDAO().getAll(SEGUNDA_DOSIS, "true");
			for (Vacunacion vacunacion : vacunaciones) {
				if (vacunacion.getPaciente().getRegion().getId() == region) {
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
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibida de la primera
	 * dosiss.
	 * 
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public double consultarPorcentajeVacunadosSobreRecibidasPrimeraDosis() throws GSNSException {
		try {
			int totalVacunados = consultarTotalVacunadosPrimeraDosis();
			int vacunasRecibidas = 0;
			Collection<LoteVacunas> lotes = gestorGSNS.getLoteVacunasDAO().getAll(null, null);
			for (LoteVacunas loteVacunas : lotes) {
				vacunasRecibidas += loteVacunas.getCantidad();
			}
			if (vacunasRecibidas == 0) {
				return 0;
			} else {
				return (totalVacunados / (vacunasRecibidas * 1.0)) * 100;
			}
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException(
					"Se ha producido un error al consultar el porcentaje de vacunados con la primera dosis.");
		}
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibida de la primera
	 * dosiss.
	 * 
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public double consultarPorcentajeVacunadosSobreRecibidasSegundaDosis() throws GSNSException {
		try {
			int totalVacunados = consultarTotalVacunadosSegundaDosis();
			int vacunasRecibidas = 0;
			Collection<LoteVacunas> lotes = gestorGSNS.getLoteVacunasDAO().getAll(null, null);
			for (LoteVacunas loteVacunas : lotes) {
				vacunasRecibidas += loteVacunas.getCantidad();
			}
			if (vacunasRecibidas == 0) {
				return 0;
			} else {
				return (totalVacunados / (vacunasRecibidas * 1.0)) * 100;
			}
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException(
					"Se ha producido un error al consultar el porcentaje de vacunados con la segunda dosis.");
		}
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibidas de una región
	 * con la primera dosis.
	 * 
	 * @param region La región por la que se filtra la consulta.
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas de la regió con
	 *         la primera dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public double consultarPorcentajeVacunadosSobreRecibidasEnRegionPrimeraDosis(int region) throws GSNSException {
		try {
			int totalVacunados = consultarTotalVacunadosPorRegionPrimeraDosis(region);
			int vacunasRecibidas = 0;
			Collection<EntregaVacunas> entregas = gestorGSNS.getEntregaDAO().getAll(null, null);
			for (EntregaVacunas entrega : entregas) {
				if (entrega.getRegion().getId() == region) {
					vacunasRecibidas += entrega.getLote().getCantidad();
				}
			}
			if (vacunasRecibidas == 0) {
				return 0;
			} else {
				return (totalVacunados / (vacunasRecibidas * 1.0)) * 100;
			}
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException(
					"Se ha producido un error al consultar el porcentaje de vacunados por región con la primera dosis.");
		}
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibidas de una región
	 * con la segunda dosis.
	 * 
	 * @param region La región por la que se filtra la consulta.
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas de la regió con
	 *         la segunda dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public double consultarPorcentajeVacunadosSobreRecibidasEnRegionSegundaDosis(int region) throws GSNSException {
		try {
			int totalVacunados = consultarTotalVacunadosPorRegionPrimeraDosis(region);
			int vacunasRecibidas = 0;
			Collection<EntregaVacunas> entregas = gestorGSNS.getEntregaDAO().getAll(null, null);
			for (EntregaVacunas entrega : entregas) {
				if (entrega.getRegion().getId() == region) {
					vacunasRecibidas += entrega.getLote().getCantidad();
				}
			}
			if (vacunasRecibidas == 0) {
				return 0;
			} else {
				return (totalVacunados / (vacunasRecibidas * 1.0)) * 100;
			}
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando estadísticas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException(
					"Se ha producido un error al consultar el porcentaje de vacunados por región con la segunda dosis.");
		}
	}

}