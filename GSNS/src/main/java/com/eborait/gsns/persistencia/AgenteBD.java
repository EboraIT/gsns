package com.eborait.gsns.persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public AgenteBD() throws SQLException {
		conectarBD();
	}

	public static AgenteBD getAgente() throws SQLException {
		return agente == null ? new AgenteBD() : agente;
	}

	public void conectarBD() throws SQLException {
		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		conexion = DriverManager.getConnection(URL, BDConstantes.DBUSER, BDConstantes.DBPASS);
	}

	public void desconectarBD() {
		// TODO - implement AgenteBD.desconectarBD
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet select(String sql) {
		// TODO - implement AgenteBD.select
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public int insert(String sql) {
		// TODO - implement AgenteBD.insert
		throw new UnsupportedOperationException();
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