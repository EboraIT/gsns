package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.persistencia.DAOFactory;
import com.eborait.gsns.persistencia.LoteVacunasDAO;

public class GestorRepartoVacunas {
	
	
	
	/**
	 * 
	 * @param fecha
	 * @param tipo
	 * @param cantidad
	 */
	public  boolean altaNuevoLoteVacunas(String id,Date fecha, String tipo, int cantidad,String nombreVacuna,String farmaceutica,String fechaAprobacion) throws Exception{
		boolean altaLote=false;
		TipoVacuna tipoVacuna = new TipoVacuna(nombreVacuna, farmaceutica, fechaAprobacion);
		LoteVacunas v= new LoteVacunas(id,fecha,tipo,cantidad);
		
		try {
			return DAOFactory.getLoteVacunasDAO().insert(v) == 1;
		} catch (SQLException sqle) {
			System.out.println("Excepción insertando entrega:\n\n" + sqle.getStackTrace());
			throw new Exception("Se ha producido un error al dar de alta la entrega de vacunas.");
		}
		
	}

	public List<EntregaVacunas> calcularEntregasRegion(RegionEnum region) throws Exception {
		ArrayList<EntregaVacunas> entregaVacunas = null;
		//entregaVacunas.SeleccionarEntregas(RegionEnum)
		return entregaVacunas;
			 
		
		
		
		
	}

}