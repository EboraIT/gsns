package com.eborait.gsns.dominio.controller;

import com.eborait.gsns.dominio.entitymodel.*;
import com.eborait.gsns.persistencia.VacunacionDAO;

public class GestorEstadisticas {

	public int consultarTotalVacunados() throws Exception {
		int totalVacunados=0;
		VacunacionDAO v = null ;
		
		for (int i=0;i<v.seleccionarVacunaciones().size();i++) {
			totalVacunados=+1;
		}
		return totalVacunados;
	
		
	}

	/**
	 * 
	 * @param region
	 * @return 
	 */
	public int consultarTotalVacunadosPorRegion(RegionEnum region) {
		int totalVacunadosRegion=0;
		VacunacionDAO v = null ;
		
		for (int i=0;i<v.seleccionarVacunaciones(region).size();i++) {
			totalVacunadosRegion=+1;
		}
		return totalVacunadosRegion;
	}

	public int consultarPorcentajeVacunadosSobreRecibidas() throws Exception {
		int totalVacunados= consultarTotalVacunados();
		/*Añadir metodo que devuelva el total vacunas recibidas**/
		int vacunas_recibidas = 999999;
		
		return (totalVacunados/vacunas_recibidas) *100;
	}

	/**
	 * 
	 * @param region
	 * @return 
	 */
	public int consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum region) {
		int totalVacunadosPorRegion= consultarTotalVacunadosPorRegion(region);
		/*Añadir metodo que devuelva el total vacunas recibidas**/
		int vacunas_recibidas = 999999;
		
		return (totalVacunadosPorRegion/vacunas_recibidas) *100;
	}

}