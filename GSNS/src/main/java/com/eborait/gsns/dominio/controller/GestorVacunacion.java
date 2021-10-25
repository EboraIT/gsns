package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;
import java.util.Date;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;
import com.eborait.gsns.persistencia.DAOFactory;

/**
 * Realiza la gestión de vacunación.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 *
 */
public class GestorVacunacion {

	/**
	 * Da de alta una nueva entrega de vacunas.
	 * 
	 * @param id              Identificador de la entrega.
	 * @param lote            Lote de vacunación.
	 * @param fecha           Fecha de alta.
	 * @param cantidad        Cantidad.
	 * @param prioridad       Prioridad.
	 * @param nombreVacuna    Nombre de la vacuna.
	 * @param farmaceutica    Farmacéutica que ha desarrollado la vacuna.
	 * @param fechaAprobacion Fecha de aprobación de la vacuna.
	 * @param region          Región de la entrega.
	 * @throws Exception Si se produce una excepción al insertar.
	 */
	public void altaEntregaVacunas(String id, String lote, Date fecha, int cantidad, int prioridad, String nombreVacuna,
			String farmaceutica, String fechaAprobacion, int region) throws Exception {
		TipoVacuna tipoVacuna = new TipoVacuna(nombreVacuna, farmaceutica, fechaAprobacion);
		EntregaVacunas entregaVac = new EntregaVacunas(id, lote, fecha, cantidad, prioridad, tipoVacuna, region);
		try {
			DAOFactory.getEntregaDAO().insert(entregaVac);
		} catch (SQLException sqle) {
			System.out.println("Excepción insertando entrega:\n\n" + sqle.getStackTrace());
			throw new Exception("Se ha producido un error al dar de alta la entrega de vacunas.");
		}
	}

	/**
	 * Registra la vacunación de un paciente.
	 * 
	 * @param fecha        Fecha de vacunación.
	 * @param nombre       Nombre de la persona vacunada.
	 * @param apellidos    Apellidos de la persona vacunada.
	 * @param nif          NIF de la persona vacunada.
	 * @param tipo         Tipo de vacuna administrada.
	 * @param prioridad    Grupo de prioridad de la persona vacunada.
	 * @param region       Región a la que pertenece la persona vacunada.
	 * @param segundaDosis Si es primera o segunda dósis.
	 * @throws Exception Si se produce una excepción al insertar.
	 */
	public void registrarVacunacion(Date fecha, String nombre, String apellidos, String nif, TipoVacuna tipo,
			int prioridad, int region, boolean segundaDosis) throws Exception {
		Paciente paciente = new Paciente(nif, nombre, apellidos, prioridad, region);
		Vacunacion vacunacion = new Vacunacion(tipo, paciente, fecha, segundaDosis);
		try {
			DAOFactory.getVacunacionDAO().insert(vacunacion);
		} catch (SQLException sqle) {
			System.out.println("Excepción insertando vacunación:\n\n" + sqle.getStackTrace());
			throw new Exception("Se ha producido un error registrar la vacunación.");
		}
	}

}