package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Logger;
import java.util.logging.Level;

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
	private final GestorGSNS gestorGSNS;

	/** Constante segunda_dosis. */
	private static final String SEGUNDA_DOSIS = "segunda_dosis";

	/** Constante del mensaje de excepción. */
	private static final String EXCEPCION_ESTADISTICAS = "Excepción consultando estadísticas: ";

	/** Objeto Logger. */
	private static final Logger LOG = Logger.getLogger(GestorEstadisticas.class.getName());

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
	 * @param segundaDosis Si se filtra por primera o segunda dosis.
	 * @return El número total de vacunados con la primera dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunados(boolean segundaDosis) throws GSNSException {
		try {
			return gestorGSNS.getVacunacionDAO().getAll(SEGUNDA_DOSIS, String.valueOf(segundaDosis)).size();
		} catch (SQLException sqle) {
			LOG.log(Level.SEVERE, "{0}", EXCEPCION_ESTADISTICAS + sqle.getMessage());
			LOG.log(Level.SEVERE, "", sqle);
			throw new GSNSException(
					"Se ha producido un error al consultar el número total de vacunados.");
		}
	}

	/**
	 * Consulta el número total de vacunados de una región con primera dosis.
	 * 
	 * @param region       La región por la que se filtra la consulta.
	 * @param segundaDosis Si se filtra por primera o segunda dosis.
	 * @return El número total de vacunados de la región con la primera dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int consultarTotalVacunadosPorRegion(int region, boolean segundaDosis) throws GSNSException {
		try {
			int contador = 0;
			Collection<Vacunacion> vacunaciones = gestorGSNS.getVacunacionDAO().getAll(SEGUNDA_DOSIS,
					String.valueOf(segundaDosis));
			for (Vacunacion vacunacion : vacunaciones) {
				if (vacunacion.getPaciente().getRegion().getId() == region) {
					contador++;
				}
			}
			return contador;
		} catch (SQLException sqle) {
			LOG.log(Level.SEVERE, "{0}", EXCEPCION_ESTADISTICAS + sqle.getMessage());
			LOG.log(Level.SEVERE, "", sqle);
			throw new GSNSException("Se ha producido un error al consultar el número total de vacunados por región.");
		}
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibida de la primera
	 * dosiss.
	 * 
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas.
	 * @param segundaDosis Si se filtra por primera o segunda dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public double consultarPorcentajeVacunadosSobreRecibidas(boolean segundaDosis) throws GSNSException {
		try {
			int totalVacunados = consultarTotalVacunados(segundaDosis);
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
			LOG.log(Level.SEVERE, "{0}", EXCEPCION_ESTADISTICAS + sqle.getMessage());
			LOG.log(Level.SEVERE, "", sqle);
			throw new GSNSException(
					"Se ha producido un error al consultar el porcentaje de vacunados.");
		}
	}

	/**
	 * Calcula el porcentaje de vacunaciones sobre vacunas recibidas de una región
	 * con la primera dosis.
	 * 
	 * @param region       La región por la que se filtra la consulta.
	 * @param segundaDosis Si se filtra por primera o segunda dosis.
	 * @return El porcentaje de vacunaciones sobre vacunas recibidas de la región
	 *         con la primera dosis.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public double consultarPorcentajeVacunadosSobreRecibidasEnRegion(int region, boolean segundaDosis)
			throws GSNSException {
		try {
			int totalVacunados = consultarTotalVacunadosPorRegion(region, segundaDosis);
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
			LOG.log(Level.SEVERE, "{0}", EXCEPCION_ESTADISTICAS + sqle.getMessage());
			LOG.log(Level.SEVERE, "", sqle);
			throw new GSNSException(
					"Se ha producido un error al consultar el porcentaje de vacunados por región.");
		}
	}

}