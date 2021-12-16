package com.eborait.gsns.dominio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eborait.gsns.Utilidades;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import com.eborait.gsns.persistencia.DAOFactory;
import com.eborait.gsns.persistencia.PacienteDAO;
import com.eborait.gsns.persistencia.VacunacionDAO;

class GestorEstadisticasTest {
	private static GestorEstadisticas gestorEstadisticas;
	private static VacunacionDAO vacunacionDAO;
	private static PacienteDAO pacienteDAO;
	private static Paciente paciente;
	private static Vacunacion vacunacion;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		gestorEstadisticas = new GestorEstadisticas(new GestorGSNS());
		TipoVacuna tipoVacuna = new TipoVacuna("Pfizer-Moderna-23/11/2021");
		paciente = new Paciente("01915362H", 6, 7, "Jorge", "Fernandez Escolano", false);
		vacunacion = new Vacunacion(0, tipoVacuna, paciente, Util.parseFecha("03/01/2022"), false);
		vacunacionDAO = DAOFactory.getVacunacionDAO();
		pacienteDAO = DAOFactory.getPacienteDAO();
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	final void testConsultarTotalVacunados() throws SQLException {
		try {
			assertEquals(0, gestorEstadisticas.consultarTotalVacunados(false));
			assertEquals(0, gestorEstadisticas.consultarTotalVacunados(true));
			pacienteDAO.insert(vacunacion.getPaciente());
			vacunacionDAO.insert(vacunacion);
			assertEquals(1, gestorEstadisticas.consultarTotalVacunados(false));
			vacunacion.setId(Utilidades.max());
			vacunacionDAO.delete(vacunacion);
			vacunacion.setSegundaDosis(true);
			vacunacionDAO.insert(vacunacion);
			vacunacion.setSegundaDosis(false);
			assertEquals(1, gestorEstadisticas.consultarTotalVacunados(true));
		} catch (GSNSException gsnse) {
			fail("Excepción GSNSException no esperada.");
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			vacunacion.setId(Utilidades.max());
			vacunacionDAO.delete(vacunacion);
			pacienteDAO.delete(vacunacion.getPaciente());
		}
	}

	@Test
	final void testConsultarTotalVacunadosPorRegion() throws SQLException {
		try {
			int region = vacunacion.getPaciente().getRegion().getId();
			assertEquals(0, gestorEstadisticas.consultarTotalVacunadosPorRegion(region, false));
			assertEquals(0, gestorEstadisticas.consultarTotalVacunadosPorRegion(region, true));
			pacienteDAO.insert(vacunacion.getPaciente());
			vacunacionDAO.insert(vacunacion);
			assertEquals(1, gestorEstadisticas.consultarTotalVacunadosPorRegion(region, false));
			vacunacion.setId(Utilidades.max());
			vacunacionDAO.delete(vacunacion);
			vacunacion.setSegundaDosis(true);
			vacunacionDAO.insert(vacunacion);
			vacunacion.setSegundaDosis(false);
			assertEquals(1, gestorEstadisticas.consultarTotalVacunadosPorRegion(region, true));
			assertEquals(0, gestorEstadisticas.consultarTotalVacunadosPorRegion(897, true));
		} catch (GSNSException gsnse) {
			fail("Excepción GSNSException no esperada.");
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			vacunacion.setId(Utilidades.max());
			vacunacionDAO.delete(vacunacion);
			pacienteDAO.delete(vacunacion.getPaciente());
		}
	}

	@Test
	final void testConsultarPorcentajeVacunadosSobreRecibidas() {
		// TODO
	}

	@Test
	final void testConsultarPorcentajeVacunadosSobreRecibidasEnRegion() {
		// TODO
	}

}
