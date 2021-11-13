package com.eborait.gsns.persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.derby.jdbc.EmbeddedDriver;

/**
 * La clase AgenteBD realiza las operaciones contra la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 *
 */
public class AgenteBD implements BDConstantes {
	/**
	 * Instancia del agente.
	 */
	private static AgenteBD agente;
	/**
	 * Conexión con la base de datos.
	 */
	private static Connection conexion;
	/**
	 * Identificador ODBC de la base de datos.
	 */
	private static final String URL = CONNECTION_STRING + ";create=false";
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
	public static void conectarBD() throws SQLException {
		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			conexion = DriverManager.getConnection(URL, DBUSER, DBPASS);
		} catch (SQLException sqle) {
			System.out.println("Error conectando con la base de datos:\n\n" + sqle.getMessage());
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
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error cerrando la conexión con la base de datos:\n\n" + sqle.getMessage());
			throw sqle;
		}
	}

	/**
	 * Realiza una consulta a la base de datos.
	 * 
	 * @param sql Sentencia de consulta a ejecutar.
	 * @return Los resultados de la consulta en un ResultSet
	 * @throws SQLException Si se produce algún error al consultar en la base de
	 *                      datos.
	 */
	public Collection<Collection<Object>> select(String sql) throws SQLException {
		Collection<Collection<Object>> data;
		try {
			conectarBD();
			try (Statement stmt = conexion.createStatement()) {
				ResultSet rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				data = new ArrayList<>();
				while (rs.next()) {
					Collection<Object> rowData = new ArrayList<>();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						rowData.add(rs.getObject(i));
					}
					data.add(rowData);
				}
			}
			desconectarBD();
			return data;
		} catch (SQLException sqle) {
			System.out.println("Error consultando a la base de datos:\n\n" + sqle.getMessage());
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
			return prepareAndExecuteStatement(sql);
		} catch (SQLException sqle) {
			System.out.println("Error insertando en la base de datos:\n\n" + sqle.getMessage());
			throw sqle;
		}
	}

	/**
	 * Realiza la actualización en la base de datos.
	 * 
	 * @param sql Sentencia de actualización a ejecutar
	 * @return El número de filas afectadas al ejecutar la sentencia.
	 * @throws SQLException Si se produce algún error al actualizar en la base de
	 *                      datos.
	 */
	public int update(String sql) throws SQLException {
		try {
			return prepareAndExecuteStatement(sql);
		} catch (SQLException sqle) {
			System.out.println("Error actualizando en la base de datos:\n\n" + sqle.getMessage());
			throw sqle;
		}
	}

	/**
	 * Realiza el borrado en la base de datos.
	 * 
	 * @param sql Sentencia de borrado a ejecutar
	 * @return El número de filas afectadas al ejecutar la sentencia.
	 * @throws SQLException Si se produce algún error al borrar en la base de datos.
	 */
	public int delete(String sql) throws SQLException {
		try {
			return prepareAndExecuteStatement(sql);
		} catch (SQLException sqle) {
			System.out.println("Error borrando en la base de datos:\n\n" + sqle.getMessage());
			throw sqle;
		}
	}

	private int prepareAndExecuteStatement(String sql) throws SQLException {
		conectarBD();
		int res;
		try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
			res = stmt.executeUpdate();
		}
		desconectarBD();
		return res;
	}

}