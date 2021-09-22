package com.eborait.gsns.dominio.entitymodel;

import java.util.Date;

import com.eborait.gsns.persistencia.EntregaDAO;

public class EntregaVacunas {

	TipoVacuna tipo;
	RegionEnum region;
	GrupoPrioridad grupoPrioridad;
	LoteVacunas lote;
	EntregaDAO entregaDao;
	private Date fecha;
	private int cantidad;

}