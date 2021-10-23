package com.eborait.gsns.dominio.entitymodel;

import java.util.Date;

public class Vacunacion {

	private TipoVacuna vacuna;
	private Paciente paciente;
	private Date fecha;
	private boolean segundaDosis;

	public Vacunacion(TipoVacuna vacuna, Paciente paciente, Date fecha, boolean segundaDosis) {
		this.vacuna = vacuna;
		this.paciente = paciente;
		this.fecha = fecha;
		this.segundaDosis = segundaDosis;
	}

	public TipoVacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(TipoVacuna vacuna) {
		this.vacuna = vacuna;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isSegundaDosis() {
		return segundaDosis;
	}

	public void setSegundaDosis(boolean segundaDosis) {
		this.segundaDosis = segundaDosis;
	}

	@Override
	public String toString() {
		return "Vacunacion [vacuna=" + vacuna + ", paciente=" + paciente + ", fecha=" + fecha + ", isSegundaDosis="
				+ segundaDosis + "]";
	}

}