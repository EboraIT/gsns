package com.eborait.gsns.dominio.entitymodel;

import java.util.ArrayList;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public enum GrupoPrioridad {
	RESIDENTE_ANCIANO(1, "Ancianos en residencias"), SANITARIO(2, "Personal sanitario"),
	TRABAJADOR_ESENCIAL(3, "Trabajadores esenciales"), ANCIANO(4, "Ancianos"), ADULTO(5, "Adultos"),
	JOVEN(6, "Jóvenes"), NINO(7, "Niños");

	private Collection<Paciente> pacientes;
	private Collection<EntregaVacunas> entregas;
	private final int prioridad;
	private final String nombre;

	private GrupoPrioridad(int prioridad, String nombre) {
		this.prioridad = prioridad;
		this.nombre = nombre;
		this.entregas = new ArrayList<>();
		this.pacientes = new ArrayList<>();
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

	public int getPrioridad() {
		return prioridad;
	}

	public static GrupoPrioridad valueOf(int prioridad) throws GSNSException {
		for (GrupoPrioridad gp : values()) {
			if (gp.getPrioridad() == prioridad) {
				return gp;
			}
		}
		throw new GSNSException("El grupo de prioridad no existe.");
	}
	
	public static String[] getNombres() {
		String[] nombres = new String[values().length];
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = values()[i].getNombre();
		}
		return nombres;
	}

}