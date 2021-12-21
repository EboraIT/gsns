package com.eborait.gsns.persistencia;

import java.io.IOException;
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
import java.util.Properties;

import org.apache.derby.jdbc.EmbeddedDriver;
import org.jasypt.properties.EncryptableProperties;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * La clase AgenteBD realiza las operaciones contra la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 *
 */
public class AgenteBD {

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
	private static final String URL = BDConstantes.CONNECTION_STRING + ";create=false";

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
		agente = agente == null ? new AgenteBD() : agente;
		return agente;
	}

	/**
	 * Obtiene la contraseña de la base de datos de un fichero de configuración.
	 * 
	 * @return La contraseña de la base de datos.
	 * @throws SQLException Si se produce algún error al leer el fichero.
	 */
	private static String getEncryptedPass() throws SQLException {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword("jasypt");

		Properties props = new EncryptableProperties(encryptor);
		try {
			props.load(AgenteBD.class.getClassLoader().getResourceAsStream("datasource.properties"));
			return props.getProperty("datasource.password");
		} catch (IOException ioe) {
			throw new SQLException(
					"Error leyendo la contraseña de la base de datos del fichero de configuración: " + ioe.getMessage(),
					ioe);
		}
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
			conexion = DriverManager.getConnection(URL, BDConstantes.DBUSER, getEncryptedPass());
		} catch (SQLException sqle) {
			throw new SQLException("Error conectando con la base de datos: " + sqle.getMessage(), sqle);
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
			throw new SQLException("Error cerrando la conexión con la base de datos: " + sqle.getMessage(), sqle);
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
			throw new SQLException("Error consultando a la base de datos: " + sqle.getMessage(), sqle);
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
			throw new SQLException("Error insertando en la base de datos: " + sqle.getMessage(), sqle);
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
			throw new SQLException("Error actualizando en la base de datos: " + sqle.getMessage(), sqle);
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
			throw new SQLException("Error borrando en la base de datos: " + sqle.getMessage(), sqle);
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