package com.eborait.gsns.dominio.controller;

import com.eborait.gsns.dominio.entitymodel.GrupoPrioridad;
import com.eborait.gsns.dominio.entitymodel.RegionEnum;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import com.eborait.gsns.persistencia.DAOFactory;
import com.eborait.gsns.persistencia.EntregaDAO;
import com.eborait.gsns.persistencia.LoteVacunasDAO;
import com.eborait.gsns.persistencia.PacienteDAO;
import com.eborait.gsns.persistencia.VacunacionDAO;

public class GestorGSNS {

	/** El gestor de estadisticas. */
	private GestorEstadisticas gestorEstadisticas;

	/** El gestor del reparto de vacunas. */
	private GestorRepartoVacunas gestorRepartoVacunas;

	/** El gestor de vacunaciones. */
	private GestorVacunacion gestorVacunacion;

	public GestorGSNS() {
		this.gestorEstadisticas = new GestorEstadisticas(this);
		this.gestorRepartoVacunas = new GestorRepartoVacunas(this);
		this.gestorVacunacion = new GestorVacunacion(this);
	}

	/**
	 *
	 * @return El gestor de estadísticas.
	 */
	public GestorEstadisticas getGestorEstadisticas() {
		return gestorEstadisticas;
	}

	/**
	 *
	 * @return El gestor del reparto de vacunas.
	 */
	public GestorRepartoVacunas getGestorRepartoVacunas() {
		return gestorRepartoVacunas;
	}

	/**
	 * 
	 * @return El gestor de vacunaciones.
	 */
	public GestorVacunacion getGestorVacunacion() {
		return gestorVacunacion;
	}

	/**
	 * Se obtiene la región mediante su identificador.
	 *
	 * @param region El identificador de la región.
	 * @return La región.
	 * @throws GSNSException Si la región no existe.
	 */
	public RegionEnum getRegionPorId(int region) throws GSNSException {
		return RegionEnum.valueOf(region);
	}

	/**
	 * Se obtienen los nombres de las regiones en un array de tipo String.
	 *
	 * @return Los nombres de las regiones.
	 */
	public String[] getNombresRegion() {
		return RegionEnum.getNombres();
	}

	/**
	 * Se obtienen los nombres de los grupos de prioridad.
	 *
	 * @return Los nombres de los grupos de prioridad.
	 */
	public String[] getNombresGrupoPrioridad() {
		return GrupoPrioridad.getNombres();
	}

	/**
	 * Devuelve una instancia de EntregaDAO.
	 * 
	 * @return Objeto EntregaDAO.
	 * @see EntregaDAO
	 */
	public EntregaDAO getEntregaDAO() {
		return DAOFactory.getEntregaDAO();
	}

	/**
	 * Devuelve una instancia de LoteVacunasDAO.
	 * 
	 * @return Objeto LoteVacunasDAO.
	 * @see LoteVacunasDAO
	 */
	public LoteVacunasDAO getLoteVacunasDAO() {
		return DAOFactory.getLoteVacunasDAO();
	}

	/**
	 * Devuelve una instancia de VacunacionDAO.
	 *
	 * @return Objeto VacunacionDAO.
	 * @see VacunacionDAO
	 */
	public VacunacionDAO getVacunacionDAO() {
		return DAOFactory.getVacunacionDAO();
	}

	/**
	 * Devuelve una instancia de PacienteDAO.
	 *
	 * @return Objeto PacienteDAO.
	 * @see PacienteDAO
	 */
	public PacienteDAO getPacienteDAO() {
		return DAOFactory.getPacienteDAO();
	}

}
