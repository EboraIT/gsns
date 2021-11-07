package com.eborait.gsns.dominio.controller;

import java.sql.SQLException;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

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

	/** El gestor de la aplicación. */
	private GestorGSNS gestorGSNS;

	/**
	 * Instancia un nuevo GestorVacunacion.
	 * 
	 * @param gestorGSNS El gestor de la aplicación.
	 */
	public GestorVacunacion(GestorGSNS gestorGSNS) {
		this.gestorGSNS = gestorGSNS;
	}

	/**
	 * Da de alta una nueva entrega de vacunas.
	 * 
	 * @param id        Identificador de la entrega.
	 * @param lote      Lote de vacunación.
	 * @param fecha     Fecha de alta.
	 * @param cantidad  Cantidad.
	 * @param prioridad Prioridad.
	 * @param vacuna    Tipo de vacuna.
	 * @param region    Región de la entrega.
	 * @return Devuelve 1 si se ha registrado correctamente, 0 de lo contrario.
	 * @throws GSNSException Si se produce una excepción al insertar.
	 */
	public boolean altaEntregaVacunas(String id, String lote, String fecha, int cantidad, int prioridad, String vacuna,
			int region) throws GSNSException {
		TipoVacuna tipoVacuna = new TipoVacuna(vacuna);
		try {
			EntregaVacunas entregaVac = new EntregaVacunas(id, lote, Util.parseFecha(fecha), cantidad, prioridad,
					tipoVacuna, region);
			return gestorGSNS.getEntregaDAO().insert(entregaVac) == 1;
		} catch (SQLException sqle) {
			System.out.println("Excepción insertando entrega:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException("Se ha producido un error al dar de alta la entrega de vacunas.");
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
	 * @return Devuelve 1 si se ha registrado correctamente, 0 de lo contrario.
	 * @throws GSNSException Si se produce una excepción al insertar.
	 */
	public boolean registrarVacunacion(String fecha, String nombre, String apellidos, String nif, String tipo,
			int prioridad, int region, boolean segundaDosis) throws GSNSException {
		try {
			Paciente paciente = new Paciente(nif, nombre, apellidos, prioridad, region);
			Vacunacion vacunacion = new Vacunacion(0, new TipoVacuna(tipo), paciente, Util.parseFecha(fecha),
					segundaDosis);
			return gestorGSNS.getVacunacionDAO().insert(vacunacion) == 1;
		} catch (SQLException sqle) {
			System.out.println("Excepción insertando vacunación:\n\n" + sqle.getMessage());
			sqle.printStackTrace();
			throw new GSNSException("Se ha producido un error al registrar la vacunación.");
		}
	}

}