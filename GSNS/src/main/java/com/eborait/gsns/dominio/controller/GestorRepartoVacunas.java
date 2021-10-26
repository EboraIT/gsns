package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
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
	 * 
	 * @param id              Identificador del lote.
	 * @param fecha           Fecha de alta del lote.
	 * @param cantidad        Cantidad de vacunas en el lote.
	 * @param nombreVacuna    Nombre de la vacuna.
	 * @param farmaceutica    Farmacéutica que ha desarrollado la vacuna.
	 * @param fechaAprobacion Fecha de aprobación de la vacuna.
	 * @return Devuelve 1 si se ha registrado correctamente, 0 de lo contrario.
	 * @throws Exception Si se produce una excepción al insertar.
	 */
	public boolean altaNuevoLoteVacunas(String id, Date fecha, int cantidad, String nombreVacuna, String farmaceutica,
			String fechaAprobacion) throws Exception {
		TipoVacuna tipo = new TipoVacuna(nombreVacuna, farmaceutica, fechaAprobacion);
		LoteVacunas lote = new LoteVacunas(id, fecha, tipo, cantidad, farmaceutica);
		try {
			return DAOFactory.getLoteVacunasDAO().insert(lote) == 1;
		} catch (SQLException sqle) {
			System.out.println("Excepción insertando lote:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new Exception("Se ha producido un error al dar de alta el lote de vacunas.");
		}

	}

	public List<EntregaVacunas> calcularEntregasRegion(RegionEnum region) throws Exception {
		ArrayList<EntregaVacunas> entregaVacunas = null;
		// entregaVacunas.SeleccionarEntregas(RegionEnum)
		return entregaVacunas;

	}

}