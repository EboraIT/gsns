package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.eborait.gsns.dominio.controller.Util;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;

class VacunacionDAOTest {

	private static VacunacionDAO vacunacionDAO;
	private Date fecha;
	private Vacunacion vacunacion;
	private TipoVacuna tipoVacuna;
	private Paciente paciente;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		vacunacionDAO = DAOFactory.getVacunacionDAO();
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
			vacunacionDAO.insert(vacunacion);
			Vacunacion vacunacionDevuelta = vacunacionDAO.get("" + vacunacionDAO.max());
			assertEquals(vacunacion, vacunacionDevuelta);
			assertThrows(Exception.class, new Executable() {
				@Override
				public void execute() throws Exception {
					vacunacionDAO.get("id_falso");
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			vacunacionDAO.delete(vacunacion);
		}
	}

	@Test
	final void testGetAll() {
	}

	@Test
	final void testInsert() throws SQLException {
		try {
			assertEquals(1, vacunacionDAO.insert(vacunacion));
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
			vacunacion.setId(vacunacionDAO.max());
			assertEquals(1, vacunacionDAO.update(vacunacion));
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			fail("Excepción SQLException no esperada.");
		} finally {
			vacunacionDAO.delete(vacunacion);
		}
	}

	@Test
	final void testDelete() {
		try {
			vacunacionDAO.insert(vacunacion);
			vacunacion.setId(vacunacionDAO.max());
			assertEquals(1, vacunacionDAO.delete(vacunacion));
			assertEquals(0, vacunacionDAO.delete(vacunacion));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

	@Test
	void testMax() throws SQLException {
	}

}