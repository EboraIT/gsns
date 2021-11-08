package com.eborait.gsns.dominio.entitymodel.excepciones;

/**
 * Excepción genérica de la aplicación.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 *
 */
public class GSNSException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor de la clase GSNSException.
	 * 
	 * @param mensaje Mensaje de la excepción.
	 */
	public GSNSException(String mensaje) {
		super(mensaje);
	}

}