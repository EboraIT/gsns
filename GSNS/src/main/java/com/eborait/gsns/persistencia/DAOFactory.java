package com.eborait.gsns.persistencia;

public class DAOFactory {

	private static EntregaDAO entregaDao;
	private static LoteVacunasDAO loteVacunasDao;
	private static VacunacionDAO vacunacionDao;

	public static EntregaDAO getEntregaDAO() {
		return entregaDao != null ? entregaDao : new EntregaDAO();
	}

	public static LoteVacunasDAO getLoteVacunasDAO() {
		return loteVacunasDao != null ? loteVacunasDao : new LoteVacunasDAO();
	}

	public static VacunacionDAO getVacunacionDAO() {
		return vacunacionDao != null ? vacunacionDao : new VacunacionDAO();
	}

}
