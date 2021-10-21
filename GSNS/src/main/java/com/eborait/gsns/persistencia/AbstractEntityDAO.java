package com.eborait.gsns.persistencia;

import java.sql.Date;
import java.util.Collection;

public abstract class AbstractEntityDAO<E> {

	private String id;
	private Date fechaInserccion;
	private Date fechaActualizacion;

	/**
	 * 
	 * @param id
	 */
	abstract E get(String id);

	/**
	 * 
	 * @param id
	 */
	abstract Collection<E> getAll(String criteria, String value);

	/**
	 * 
	 * @param entity
	 */
	abstract int insert(E entity);

	/**
	 * 
	 * @param entity
	 */
	abstract int update(E entity);

	/**
	 * 
	 * @param entity
	 */
	abstract int delete(E entity);

}