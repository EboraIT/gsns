package com.eborait.gsns.persistencia;

/**
 * Interfaz de constantes para la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 * 
 */
public final class BDConstantes {

	/**
	 * Constructor privado.
	 */
	private BDConstantes() {

	}

	/**
	 * Driver de Derby.
	 */
	public static final String DRIVER = "jdbc:derby";

	/**
	 * Nombre de la base de datos.
	 */
	public static final String DBNAME = "gsns_db";

	/**
	 * Conexión.
	 */
	public static final String CONNECTION_STRING = DRIVER + ":" + DBNAME;

	/**
	 * Usuario de la base de datos.
	 */
	public static final String DBUSER = "admin";

}
