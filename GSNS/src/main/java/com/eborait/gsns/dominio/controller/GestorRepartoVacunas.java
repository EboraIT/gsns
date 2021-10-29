package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import com.eborait.gsns.persistencia.DAOFactory;

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

	/**
	 * Da de alta un nuevo lote de vacunas.
	 * 
	 * @param id              Identificador del lote.
	 * @param fecha           Fecha de alta del lote.
	 * @param cantidad        Cantidad de vacunas en el lote.
	 * @param nombreVacuna    Nombre de la vacuna.
	 * @param farmaceutica    Farmacéutica que ha desarrollado la vacuna.
	 * @param fechaAprobacion Fecha de aprobación de la vacuna.
	 * @return Devuelve 1 si se ha registrado correctamente, 0 de lo contrario.
	 * @throws GSNSException Si se produce una excepción al insertar.
	 */
	public boolean altaNuevoLoteVacunas(String id, String fecha, int cantidad, String nombreVacuna, String farmaceutica,
			String fechaAprobacion) throws GSNSException {
		TipoVacuna tipo = new TipoVacuna(nombreVacuna, farmaceutica, fechaAprobacion);
		LoteVacunas lote = new LoteVacunas(id, Util.parseFecha(fecha), tipo, cantidad, farmaceutica);
		try {
			return DAOFactory.getLoteVacunasDAO().insert(lote) == 1;
		} catch (SQLException sqle) {
			System.out.println("Excepción insertando lote:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException("Se ha producido un error al dar de alta el lote de vacunas.");
		}
	}

	/**
	 * TODO
	 * 
	 * Consulta que devuelve la entrega a cada región
	 * 
	 * @param region La cual cogeremos el nombre de la region y la población.
	 * 
	 * @param IA     Tendremos también como parametro la Incidencia Acumulada que
	 *               pasará el cliente por parametro
	 * 
	 * @return cantidad Devuelve un entero con la cantidad de vacunas repartidas.
	 *         Para resolver la cantidad será dependiendo del 60% de la poblacion y
	 *         40% de la IA.
	 */
	public int calcularEntregasRegion(int region, int ia) throws GSNSException {
		try {
			Collection<EntregaVacunas> entregas = DAOFactory.getEntregaDAO().getAll("region", "region");
			int cantidad = 0;
			for (EntregaVacunas entregaVacunas : entregas) {
				cantidad += entregaVacunas.getCantidad();
			}
			int cantidadPoblacion = RegionEnum.valueOf(region).getPoblacion();
			return (int) (cantidad / ia * 0.40 + cantidadPoblacion * 0.60);
		} catch (SQLException sqle) {
			System.out.println("Excepción consultando cantidad de entregas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
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
			Collection<LoteVacunas> lotes = DAOFactory.getLoteVacunasDAO().getAll(null, null);
			Iterator<LoteVacunas> it = lotes.iterator();
			String[] tipos = new String[lotes.size()];
			for (int i = 0; it.hasNext(); i++) {
				tipos[i] = it.next().getTipo().toString();
			}
			return tipos;
		} catch (SQLException sqle) {
			System.out.println("Excepción consultado lotes de vacunas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
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
			return DAOFactory.getLoteVacunasDAO().max("id") + 1;
		} catch (SQLException sqle) {
			System.out.println("Excepción consultado id de lote de vacunas:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException("Se ha producido un error al generar el identificador de lote.");
		}
	}

}