package com.eborait.gsns.dominio.entitymodel;

import java.util.Date;

import com.eborait.gsns.persistencia.VacunacionDAO;

public class Vacunacion {

	TipoVacuna vacuna;
	Paciente paciente;
	VacunacionDAO vacunacionDao;
	private Date fecha;
	private boolean isSegundaDosis;

	public Vacunacion(TipoVacuna vacuna, Paciente paciente, Date fecha,
			boolean isSegundaDosis) {
		super();
		this.vacuna = vacuna;
		this.paciente = paciente;
		this.vacunacionDao = new VacunacionDAO();
		this.fecha = fecha;
		this.isSegundaDosis = isSegundaDosis;
	}

	public void insertar() {
		vacunacionDao.insert(this);
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

	public VacunacionDAO getVacunacionDao() {
		return vacunacionDao;
	}

	public void setVacunacionDao(VacunacionDAO vacunacionDao) {
		this.vacunacionDao = vacunacionDao;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isSegundaDosis() {
		return isSegundaDosis;
	}

	public void setSegundaDosis(boolean isSegundaDosis) {
		this.isSegundaDosis = isSegundaDosis;
	}

	@Override
	public String toString() {
		return "Vacunacion [vacuna=" + vacuna + ", paciente=" + paciente + ", vacunacionDao=" + vacunacionDao
				+ ", fecha=" + fecha + ", isSegundaDosis=" + isSegundaDosis + "]";
	}

}