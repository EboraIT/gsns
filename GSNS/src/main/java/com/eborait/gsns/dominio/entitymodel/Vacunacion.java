package com.eborait.gsns.dominio.entitymodel;

import java.util.Date;

import com.eborait.gsns.persistencia.VacunacionDAO;

public class Vacunacion {

	TipoVacuna vacuna;
	Paciente paciente;
	VacunacionDAO vacunacionDao;
	private Date fecha;
	private boolean isSegundaDosis;

}