package com.eborait.gsns.persistencia;

/**
 * Crea (si es necesario) y devuelve los objetos DAO siguiendo el patrón
 * Singleton.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 *
 */
public class DAOFactory {

	/**
	 * Objeto EntregaDAO.
	 */
	private static EntregaDAO entregaDao;
	/**
	 * Objeto LoteVacunasDAO.
	 */
	private static LoteVacunasDAO loteVacunasDao;
	/**
	 * Objeto VacunacionDAO.
	 */
	private static VacunacionDAO vacunacionDao;
	/**
	 * Objeto VacunacionDAO.
	 */
	private static PacienteDAO pacienteDAO;

	/**
	 * Instancia si es necesario el objeto EntregaDAO y lo devuelve.
	 * 
	 * @return Objeto EntregaDAO.
	 * @see EntregaDAO
	 */
	public static EntregaDAO getEntregaDAO() {
		if (entregaDao == null) {
			entregaDao = new EntregaDAO();
		}
		return entregaDao;
	}

	/**
	 * Instancia si es necesario el objeto LoteVacunasDAO y lo devuelve.
	 * 
	 * @return Objeto LoteVacunasDAO.
	 * @see LoteVacunasDAO
	 */
	public static LoteVacunasDAO getLoteVacunasDAO() {
		if (loteVacunasDao == null) {
			loteVacunasDao = new LoteVacunasDAO();
		}
		return loteVacunasDao;
	}

	/**
	 * Instancia si es necesario el objeto VacunacionDAO y lo devuelve.
	 *
	 * @return Objeto VacunacionDAO.
	 * @see VacunacionDAO
	 */
	public static VacunacionDAO getVacunacionDAO() {
		if (vacunacionDao == null) {
			vacunacionDao = new VacunacionDAO();
		}
		return vacunacionDao;
	}

	/**
	 * Instancia si es necesario el objeto PacienteDAO y lo devuelve.
	 *
	 * @return Objeto PacienteDAO.
	 * @see PacienteDAO
	 */
	public static PacienteDAO getPacienteDAO() {
		if (pacienteDAO == null) {
			pacienteDAO = new PacienteDAO();
		}
		return pacienteDAO;
	}

}
