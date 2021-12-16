package com.eborait.gsns.dominio.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import com.eborait.gsns.persistencia.AgenteBD;
import com.eborait.gsns.persistencia.DAOFactory;
import com.eborait.gsns.persistencia.EntregaDAO;
import com.eborait.gsns.persistencia.PacienteDAO;
import com.eborait.gsns.persistencia.VacunacionDAO;

class GestorVacunacionTest {

	private static GestorVacunacion gestorVacunacion;
	private static EntregaVacunas entrega;
	private static Paciente paciente;
	private static Vacunacion vacunacion;
	private static EntregaDAO entregavacunasDAO;
	private static VacunacionDAO vacunacionDAO;
	private static PacienteDAO pacienteDAO;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		gestorVacunacion = new GestorVacunacion(new GestorGSNS());
		TipoVacuna tipoVacuna = new TipoVacuna("Pfizer-Moderna-23/11/2021");
		entrega = new EntregaVacunas("loteVacuna001", 1, Util.parseFecha("2/12/2021"), 2333, 1, tipoVacuna, 6);
		vacunacion = new Vacunacion(0, tipoVacuna, paciente, Util.parseFecha("03/01/2022"), false);
		paciente = new Paciente("01915362H", 6, 7, "Jorge", "Fernandez Escolano", false);
		entregavacunasDAO = DAOFactory.getEntregaDAO();
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
	final void testAltaEntregaVacunas() throws SQLException {
		try {
			assertTrue(gestorVacunacion.altaEntregaVacunas(entrega.getId(), entrega.getLote().getId(), "2/12/2021",
					entrega.getCantidad(), 1, entrega.getTipo().toString(), 6));
			assertThrows(GSNSException.class, new Executable() {
				@Override
				public void execute() throws GSNSException {
					gestorVacunacion.altaEntregaVacunas(entrega.getId(), entrega.getLote().getId(), "2/12/2021",
							entrega.getCantidad(), 1, entrega.getTipo().toString(), 6);
				}
			});
		} catch (GSNSException gsnse) {
			fail("Excepción GSNSException no esperada.");
		} finally {
			entregavacunasDAO.delete(entrega);
		}
	}

	@Test
	final void testRegistrarVacunacion() throws SQLException {
		try {
			assertTrue(gestorVacunacion.registrarVacunacion("03/01/2022", paciente.getNombre(), paciente.getApellidos(),
					paciente.getDni(), vacunacion.getVacuna().toString(), 1, 6, vacunacion.isSegundaDosis()));
			vacunacion.setId(max());
			vacunacionDAO.delete(vacunacion);
			assertThrows(GSNSException.class, new Executable() {
				@Override
				public void execute() throws GSNSException {
					gestorVacunacion.registrarVacunacion("03/01/2022", paciente.getNombre(), paciente.getApellidos(),
							paciente.getDni(), vacunacion.getVacuna().toString(), 1, 6, vacunacion.isSegundaDosis());
				}
			});
			vacunacion.setId(max());
		} catch (GSNSException gsnse) {
			fail("Excepción GSNSException no esperada.");
		} finally {
			vacunacionDAO.delete(vacunacion);
			pacienteDAO.delete(paciente);
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
