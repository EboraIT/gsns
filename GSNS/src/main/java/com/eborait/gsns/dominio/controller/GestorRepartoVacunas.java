package com.eborait.gsns.dominio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.persistencia.LoteVacunasDAO;

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
		if (v.insertar() == 1)
			altaLote=true;
		return altaLote;
		
	}

	public List<EntregaVacunas> calcularEntregasRegion() throws Exception {
		ArrayList<EntregaVacunas> entregaVacunas = null;
		//entregaVacunas.SeleccionarEntregas(RegionEnum)
		return entregaVacunas;
			 
		
		
		
		
	}

}