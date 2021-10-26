package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.Collection;

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

	public int consultarPorcentajeVacunadosSobreRecibidas() throws Exception {
		int totalVacunados = consultarTotalVacunados();
		/* Añadir metodo que devuelva el total vacunas recibidas **/
		int vacunas_recibidas = 999999;

		return (totalVacunados / vacunas_recibidas) * 100;
	}

	/**
	 * 
	 * @param region
	 * @return
	 */
	public int consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum region) {
		int totalVacunadosPorRegion = consultarTotalVacunadosPorRegion(region);
		/* A�adir metodo que devuelva el total vacunas recibidas **/
		int vacunas_recibidas = 999999;

		return (totalVacunadosPorRegion / vacunas_recibidas) * 100;
	}

}