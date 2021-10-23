package com.eborait.gsns.persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * La clase AgenteBD realiza las operaciones contra la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.2
 *
 */
public class AgenteBD {
	/**
	 * Instancia del agente.
	 */
	private static AgenteBD agente = null;
	/**
	 * Conexión con la base de datos.
	 */
	private static Connection conexion;
	/**
	 * Identificador ODBC de la base de datos.
	 */
	private static final String URL = BDConstantes.DRIVER + ":" + BDConstantes.DBNAME + ";create=false";

	/**
	 * 
	 * @throws SQLException Si se produce algún error al conectar con la base de
	 *                      datos.
	 */
	public AgenteBD() throws SQLException {
		conectarBD();
	}

	/**
	 * Devuelve el AgenteBD y, si es necesario, antes lo instancia.
	 * 
	 * @return El objeto AgenteBD.
	 * @throws SQLException Si se produce algún error al crear el AgenteBD.
	 * 
	 */
	public static AgenteBD getAgente() throws SQLException {
		return agente == null ? new AgenteBD() : agente;
	}

	/**
	 * Abre la conexión con la base de datos.
	 * 
	 * @throws SQLException Si se produce algún error al conectar con la base de
	 *                      datos.
	 */
	public void conectarBD() throws SQLException {
		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			conexion = DriverManager.getConnection(URL, BDConstantes.DBUSER, BDConstantes.DBPASS);
		} catch (SQLException sqle) {
			System.out.println("Error conectando con la base de datos:\n\n" + sqle.getStackTrace());
			throw sqle;
		}
	}

	/**
	 * Cierra la conexión con la base de datos.
	 * 
	 * @throws SQLException Si se produce algún error al desconectar la base de
	 *                      datos.
	 */
	public void desconectarBD() throws SQLException {
		conexion.close();
	}

	/**
	 * Realiza una consulta a la base de datos.
	 * 
	 * @param sql Sentencia de consulta a ejecutar.
	 * @return Los resultados de la consulta en un ResultSet
	 * @throws SQLException Si se produce algún error al consultar en la base de
	 *                      datos.
	 * @see ResultSet
	 */
	public ResultSet select(String sql) throws SQLException {
		try {
			conectarBD();
			Statement stmt = conexion.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			stmt.close();
			desconectarBD();
			return res;
		} catch (SQLException sqle) {
			System.out.println("Error consultando a la base de datos:\n\n" + sqle.getStackTrace());
			throw sqle;
		}
	}

	/**
	 * Realiza la inserción en la base de datos.
	 * 
	 * @param sql Sentencia de inserción a ejecutar
	 * @return El número de filas afectadas al ejecutar la sentencia.
	 * @throws SQLException Si se produce algún error al insertar en la base de
	 *                      datos.
	 */
	public int insert(String sql) throws SQLException {
		try {
			conectarBD();
			PreparedStatement stmt = conexion.prepareStatement(sql);
			int res = stmt.executeUpdate();
			stmt.close();
			desconectarBD();
			return res;
		} catch (SQLException sqle) {
			System.out.println("Error insertando en la base de datos:\n\n" + sqle.getStackTrace());
			throw sqle;
		}
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public int update(String sql) {
		// TODO - implement AgenteBD.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public int delete(String sql) {
		// TODO - implement AgenteBD.delete
		throw new UnsupportedOperationException();
	}

}