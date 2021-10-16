package com.eborait.gsns.dominio.controller;

import java.util.Date;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;

public class GestorVacunacion {

	/**
	 * 
	 * @param lote
	 * @param fecha
	 * @param cantidad
	 * @param prioridad
	 */
	public void altaEntregaVacunas(String lote, Date fecha, int cantidad, int prioridad) {
		EntregaVacunas entregaVac = new EntregaVacunas(lote, fecha, cantidad, prioridad);
		entregaVac.insertar();
	}

	/**
	 * 
	 * @param fecha
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param tipo
	 */
	public void registrarVacunacion(Date fecha, String nombre, String apellidos, String nif, TipoVacuna tipo) {
		Paciente p = new Paciente(null, null, nif, nombre, apellidos);
		Vacunacion v = new Vacunacion(tipo, p, fecha, false);
		v.insertar();
	}

}