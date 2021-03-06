package com.eborait.gsns.persistencia;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Define los métodos para implementar en los DAO.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 * 
 * @param <E> Entidad de la base de datos.
 *
 */
public interface AbstractEntityDAO<E> {

	/**
	 * Realiza una consulta a la base de datos.
	 * 
	 * @param id Identificador de la entidad que se busca.
	 * @return Una única entidad.
	 * @throws SQLException Si se produce una excepción en la consulta SQL.
	 */
	E get(String id) throws SQLException;

	/**
	 * Realiza una consulta a la base de datos.
	 * 
	 * @param criteria Columna por la que se filtra
	 * @param value    Valor por el que se filtra.
	 * @return Una colección con las entidades encontradas.
	 * @throws SQLException Si se produce una excepción en la consulta SQL.
	 */
	Collection<E> getAll(String criteria, String value) throws SQLException;

	/**
	 * Realiza una inserción en la base de datos.
	 * 
	 * @param entity entidad a insertar.
	 * @return El número de filas insertadas.
	 * @throws SQLException Si se produce una excepción en la consulta SQL.
	 */
	int insert(E entity) throws SQLException;

	/**
	 * Realiza una actualización en la base de datos.
	 * 
	 * @param entity entidad a actualizar.
	 * @return El número de filas actualizadas.
	 * @throws SQLException Si se produce una excepción en la consulta SQL.
	 */
	int update(E entity) throws SQLException;

	/**
	 * Realiza un borrado en la base de datos.
	 * 
	 * @param entity entidad a eliminar.
	 * @return El número de filas eliminadas.
	 * @throws SQLException Si se produce una excepción en la consulta SQL.
	 */
	int delete(E entity) throws SQLException;

}