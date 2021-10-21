package com.eborait.gsns.dominio.entitymodel;

import java.util.*;

public enum GrupoPrioridad {
	RESIDENTE_ANCIANO(1, "Ancianos en residencias"), SANITARIO(2, "Personal sanitario"),
	TRABAJADOR_ESENCIAL(3, "Trabajadores esenciales"), ANCIANO(4, "Ancianos"), ADULTO(5, "Adultos"),
	JOVEN(6, "Jóvenes"), NINO(7, "Niños");

	Collection<Paciente> pacientes;
	Collection<EntregaVacunas> entregas;
	private int prioridad;
	private String nombre;

	private GrupoPrioridad(int prioridad, String nombre) {
		this.prioridad = prioridad;
		this.nombre = nombre;
	}

	public Collection<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Collection<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

}