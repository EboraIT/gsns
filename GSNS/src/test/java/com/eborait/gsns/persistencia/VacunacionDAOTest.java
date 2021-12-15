package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.eborait.gsns.dominio.controller.Util;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;

class VacunacionDAOTest {

	private static VacunacionDAO vacunacionDAO;
	private static PacienteDAO pacienteDAO;
	private Date fecha;
	private Vacunacion vacunacion;
	private TipoVacuna tipoVacuna;
	private Paciente paciente;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		vacunacionDAO = DAOFactory.getVacunacionDAO();
		pacienteDAO = DAOFactory.getPacienteDAO();
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
		fecha = Util.parseFecha("2/12/2021");
		paciente = new Paciente("21715362G", 6, 6, "Roberto", "Esteban Olivares", false);
		tipoVacuna = new TipoVacuna("Pfizer", "Moderna", "23/11/2021");
		vacunacion = new Vacunacion(0, tipoVacuna, paciente, fecha, false);
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	final void testGet() throws SQLException {
		try {
			pacienteDAO.insert(paciente);
			vacunacionDAO.insert(vacunacion);
			Vacunacion vacunacionDevuelta = vacunacionDAO.get(String.valueOf(max()));
			assertEquals(vacunacion, vacunacionDevuelta);
			assertNull(vacunacionDAO.get("34897132"));
			vacunacion.setId(max());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			fail("Excepción SQLException no esperada.");
		} finally {
			vacunacionDAO.delete(vacunacion);
			pacienteDAO.delete(paciente);
		}
	}

	@Test
	final void testGetAll() throws SQLException {
		Vacunacion vacunacion2 = null;
		Paciente paciente2 = null;
		try {
			pacienteDAO.insert(paciente);
			vacunacionDAO.insert(vacunacion);
			vacunacion.setId(max());
			paciente2 = new Paciente("73847120K", 6, 6, "Roberto", "Esteban Olivares", false);
			vacunacion2 = new Vacunacion(0, tipoVacuna, paciente2, fecha, false);
			pacienteDAO.insert(paciente2);
			vacunacionDAO.insert(vacunacion2);
			vacunacion2.setId(max());
			Collection<Vacunacion> vacunas = vacunacionDAO.getAll(null, null);
			Iterator<Vacunacion> it = vacunas.iterator();
			assertEquals(vacunacion, it.next());
			assertEquals(vacunacion2, it.next());
			vacunas = vacunacionDAO.getAll("id", String.valueOf(max()));
			assertEquals(vacunacion2, vacunas.iterator().next());
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws SQLException {
					vacunacionDAO.getAll("columna_falsa", "");
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			vacunacionDAO.delete(vacunacion);
			vacunacionDAO.delete(vacunacion2);
			pacienteDAO.delete(paciente);
			pacienteDAO.delete(paciente2);
		}
	}

	@Test
	final void testInsert() throws SQLException {
		try {
			assertEquals(1, vacunacionDAO.insert(vacunacion));
			vacunacion.setId(max());
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			vacunacionDAO.delete(vacunacion);
		}
	}

	@Test
	final void testUpdate() throws SQLException {
		try {
			vacunacionDAO.insert(vacunacion);
			vacunacion.setSegundaDosis(true);
			vacunacion.setId(max());
			assertEquals(1, vacunacionDAO.update(vacunacion));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			vacunacionDAO.delete(vacunacion);
		}
	}

	@Test
	final void testDelete() {
		try {
			vacunacionDAO.insert(vacunacion);
			vacunacion.setId(max());
			assertEquals(1, vacunacionDAO.delete(vacunacion));
			assertEquals(0, vacunacionDAO.delete(vacunacion));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

	final int max() throws SQLException {
		int max = 0;
		Collection<Collection<Object>> data = AgenteBD.getAgente()
				.select("SELECT coalesce(max(id), 0) FROM vacunacion");
		for (Collection<Object> collection : data) {
			ArrayList<Object> rowData = (ArrayList<Object>) collection;
			max = Integer.parseInt(rowData.get(0).toString());
		}
		return max;
	}

}
