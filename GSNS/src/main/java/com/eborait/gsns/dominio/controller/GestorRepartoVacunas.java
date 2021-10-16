package com.eborait.gsns.dominio.controller;

import java.util.Date;
import java.util.List;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;

public class GestorRepartoVacunas {

	/**
	 * 
	 * @param fecha
	 * @param tipo
	 * @param cantidad
	 */
	public static boolean altaNuevoLoteVacunas(Date fecha, String tipo, int cantidad) throws Exception{
		boolean altaLote=false;
		LoteVacunas v= new LoteVacunas(fecha,tipo,cantidad);
		if (v.insert() == 1)
			altaLote=true;
		return altaLote;
		
	}

	public List<EntregaVacunas> calcularEntregasRegion() {
		// TODO - implement GestorRepartoVacunas.calcularEntregasRegion
		throw new UnsupportedOperationException();
	}

}