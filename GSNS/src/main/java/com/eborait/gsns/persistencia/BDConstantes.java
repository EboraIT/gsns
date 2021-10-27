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
public interface BDConstantes {
	/**
	 * Driver de Derby.
	 */
	public static final String DRIVER = "jdbc:derby";
	/**
	 * Conexión.
	 */
	public static final String CONNECTION_STRING = "jdbc:derby:gsns_db;create=true";
	/**
	 * Nombre de la base de datos.
	 */
	public static final String DBNAME = "gsns_db";
	/**
	 * Usuario de la base de datos.
	 */
	public static final String DBUSER = "admin";
	/**
	 * Contraseña de la base de datos.
	 */
	public static final String DBPASS = "admin";
	/**
	 * Puerto de la base de datos.
	 */
	public static final String DBPORT = "3308";
}
