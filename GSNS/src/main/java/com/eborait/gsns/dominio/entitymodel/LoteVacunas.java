package com.eborait.gsns.dominio.entitymodel;

import java.util.Collection;
import java.util.Date;

import com.eborait.gsns.persistencia.LoteVacunasDAO;

public class LoteVacunas {

	
	
	Collection<EntregaVacunas> entregas;
	TipoVacuna tipo;
	LoteVacunasDAO loteVacunasDao;
	private String id;
	private Date fecha;
	private int cantidad;
	private String farmaceutica;
	
	public LoteVacunas(Date fecha2, String tipo2, int cantidad2) {
		// TODO Auto-generated constructor stub
	}

	public int insertar() {
		
		LoteVacunas LoteVacunas = null;
		return LoteVacunasDAO.insertarLoteVacunas(LoteVacunas);
	}
	

}