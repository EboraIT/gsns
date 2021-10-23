package com.eborait.gsns.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;

/**
 * Realiza la gestión de Vacunacion con la base de datos.
 * 
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @since 1.0
 * @version 1.0
 * 
 * @see Vacunacion
 *
 */
public class VacunacionDAO extends AbstractEntityDAO<Vacunacion> {
	/**
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO vacunacion VALUES(%s, %s, %s, %s)";

	@Override
	public Vacunacion get(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Vacunacion> getAll(String criteria, String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Realiza una inserción en la base de datos.
	 * 
	 * @param vacunacion objeto Vacunacion a insertar.
	 * @return El número de filas insertadas.
	 * @throws SQLException Si se produce una excepción en la sentencia SQL.
	 * @see Vacunacion
	 */
	@Override
	public int insert(Vacunacion vacunacion) throws SQLException {
		return AgenteBD.getAgente().insert(String.format(INSERT, vacunacion.getVacuna().toString(),
				vacunacion.getPaciente().toDatabase(), vacunacion.getFecha(), vacunacion.isSegundaDosis()));
	}

	@Override
	public int update(Vacunacion vacunacion) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Vacunacion vacunacion) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}