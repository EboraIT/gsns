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

	public void consultarPorcentajeVacunadosSobreRecibidas() {
		// TODO - implement GestorEstadisticas.consultarPorcentajeVacunadosSobreRecibidas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param region
	 */
	public void consultarPorcentajeVacunadosSobreRecibidasEnRegion(RegionEnum region) {
		// TODO - implement GestorEstadisticas.consultarPorcentajeVacunadosSobreRecibidasEnRegion
		throw new UnsupportedOperationException();
	}

}