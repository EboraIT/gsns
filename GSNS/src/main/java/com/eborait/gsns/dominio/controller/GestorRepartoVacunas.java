package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.logging.Level;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Realiza la gestión del reparto de vacunas.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 *
 */
public class GestorRepartoVacunas {

	/** El gestor de la aplicación. */
	private final GestorGSNS gestorGSNS;

	/** Objeto Logger. */
	private static final Logger LOG = Logger.getLogger(GestorRepartoVacunas.class.getName());

	/**
	 * Instancia un nuevo GestorRepartoVacunas.
	 * 
	 * @param gestorGSNS El gestor de la aplicación.
	 */
	public GestorRepartoVacunas(GestorGSNS gestorGSNS) {
		this.gestorGSNS = gestorGSNS;
	}

	/**
	 * Da de alta un nuevo lote de vacunas.
	 * 
	 * @param id              Identificador del lote.
	 * @param fecha           Fecha de alta del lote.
	 * @param cantidad        Cantidad de vacunas en el lote.
	 * @param nombreVacuna    Nombre de la vacuna.
	 * @param farmaceutica    Farmacéutica que ha desarrollado la vacuna.
	 * @param fechaAprobacion Fecha de aprobación de la vacuna.
	 * @return Devuelve true si se ha registrado correctamente, false de lo
	 *         contrario.
	 * @throws GSNSException Si se produce una excepción al insertar.
	 */
	public boolean altaNuevoLoteVacunas(int id, String fecha, int cantidad, String nombreVacuna, String farmaceutica,
			String fechaAprobacion) throws GSNSException {
		TipoVacuna tipo = new TipoVacuna(nombreVacuna, farmaceutica, fechaAprobacion);
		LoteVacunas lote = new LoteVacunas(id, Util.parseFecha(fecha), tipo, cantidad, farmaceutica);
		try {
			return gestorGSNS.getLoteVacunasDAO().insert(lote) == 1;
		} catch (SQLException sqle) {
			LOG.log(Level.SEVERE, "{0}", "Excepción insertando lote: " + sqle.getMessage());
			LOG.log(Level.SEVERE, "", sqle);
			throw new GSNSException("Se ha producido un error al dar de alta el lote de vacunas.");
		}
	}

	/**
	 * Consulta que devuelve la entrega a cada región.
	 * 
	 * @param region La cual cogeremos el nombre de la region y la población.
	 * 
	 * @param ia     Tendremos también como parametro la Incidencia Acumulada que
	 *               pasará el cliente por parámetro.
	 * 
	 * @return cantidad Devuelve un entero con la cantidad de vacunas repartidas.
	 *         Para resolver la cantidad será dependiendo del 60% de la poblacion y
	 *         40% de la IA.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int calcularEntregasRegion(int region, int ia) throws GSNSException {
		try {
			Collection<EntregaVacunas> entregas = gestorGSNS.getEntregaDAO().getAll("region", String.valueOf(region));
			int cantidad = 0;
			for (EntregaVacunas entregaVacunas : entregas) {
				cantidad += entregaVacunas.getCantidad();
			}
			int cantidadPoblacion = gestorGSNS.getRegionPorId(region).getPoblacion();
			if (ia == 0) {
				return (int) (cantidad * 0.40 + cantidadPoblacion * 0.60);
			} else {
				return (int) (cantidad / (ia * 1.0) * 0.40 + cantidadPoblacion * 0.60);
			}
		} catch (SQLException sqle) {
			LOG.log(Level.SEVERE, "{0}", "Excepción consultando cantidad de entregas: " + sqle.getMessage());
			LOG.log(Level.SEVERE, "", sqle);
			throw new GSNSException("Se ha producido un error al calcular las entregas.");
		}
	}

	/**
	 * Agrupa en un array los diferentes tipos de vacuna.
	 * 
	 * @return Un array con los tipos de vacuna en formato String.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public String[] getTipoVacunas() throws GSNSException {
		try {
			Collection<LoteVacunas> lotes = gestorGSNS.getLoteVacunasDAO().getAll(null, null);
			Iterator<LoteVacunas> it = lotes.iterator();
			String[] tipos = new String[lotes.size()];
			for (int i = 0; it.hasNext(); i++) {
				tipos[i] = it.next().getTipo().toString();
			}
			return tipos;
		} catch (SQLException sqle) {
			LOG.log(Level.SEVERE, "{0}", "Excepción consultado lotes de vacunas: " + sqle.getMessage());
			LOG.log(Level.SEVERE, "", sqle);
			throw new GSNSException("Se ha producido un error al consultar los tipos de vacunas.");
		}
	}

	/**
	 * Genera un identificador para el lote de vacunas
	 * 
	 * @return El identificador para el nuevo lote de vacunas.
	 * @throws GSNSException Si se produce una excepción al consultar.
	 */
	public int generarIdLote() throws GSNSException {
		try {
			return gestorGSNS.getLoteVacunasDAO().maxId() + 1;
		} catch (SQLException sqle) {
			LOG.log(Level.SEVERE, "{0}", "Excepción consultado id de lote de vacunas: " + sqle.getMessage());
			LOG.log(Level.SEVERE, "", sqle);
			throw new GSNSException("Se ha producido un error al generar el identificador de lote.");
		}
	}

}