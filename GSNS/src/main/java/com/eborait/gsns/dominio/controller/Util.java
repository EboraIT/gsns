package com.eborait.gsns.dominio.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Clase de utilidades.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class Util {

	/**
	 * Transforma una fecha de String a Date.
	 * 
	 * @param fecha La fecha con formato dd/MM/yyyy.
	 * 
	 * @return Objeto Date.
	 * @throws GSNSException Si se produce una excepción al transformar la fecha.
	 * 
	 * @see Date
	 * @see SimpleDateFormat
	 */
	public static Date parseFecha(String fecha) throws GSNSException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaDate;
		try {
			fechaDate = formato.parse(fecha);
		} catch (ParseException pe) {
			System.out.println("Excepción parseando fecha:\n\n" + pe.getMessage());
			pe.printStackTrace();
			throw new GSNSException("El formato de la fecha no es correcto. El formato adecuado es dd/mm/yyyy.");
		}
		return fechaDate;
	}
}
