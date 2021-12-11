package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

 class PacienteDAOTest {
	
	private static PacienteDAO pacienteDAO;
	private Paciente paciente;
	

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		pacienteDAO = DAOFactory.getPacienteDAO();
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
		paciente = new Paciente("21715362G",6, 6, "Roberto", "Esteban Olivares", false);
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	void testGet() throws SQLException {
		try {
			pacienteDAO.insert(paciente);
			Paciente pacienteDevuelta = pacienteDAO.get("21715362G");
			assertEquals(paciente, pacienteDevuelta);
			assertThrows(Exception.class, new Executable() {
				@Override
				public void execute() throws Exception {
					pacienteDAO.get("id_falso");
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			pacienteDAO.delete(paciente);
		}
	}

	@Test
 void testGetAll() throws GSNSException, SQLException {
		Paciente paciente2 = null;
		try {
			pacienteDAO.insert(paciente);
			paciente2 = new Paciente("01915362H",6, 7, "Jorge", "Fernandez Escolano", false);
			pacienteDAO.insert(paciente2);
			Collection<Paciente> pacientes = pacienteDAO.getAll(null, null);
			Iterator<Paciente> it = pacientes.iterator();
			assertEquals(paciente, it.next());
			assertEquals(paciente2, it.next());
			pacientes = pacienteDAO.getAll("dni", "01915362H");
			assertEquals(paciente2, pacientes.iterator().next());
			assertThrows(Exception.class, new Executable() {
				@Override
				public void execute() throws Exception {
					pacienteDAO.getAll("columna_falsa", "");
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			pacienteDAO.delete(paciente);
			pacienteDAO.delete(paciente2);
		}
	}
	
	@Test
	void testInsert() throws SQLException {
		try {
			assertEquals(1, pacienteDAO.insert(paciente));
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					pacienteDAO.insert(paciente);
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			pacienteDAO.delete(paciente);
		}
	}

	@Test
	void testUpdate() throws SQLException {
		try {
			pacienteDAO.insert(paciente);
			paciente.setNombre("Alberto");;
			assertEquals(1, pacienteDAO.update(paciente));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			pacienteDAO.delete(paciente);
		}
	}

	@Test
	void testDelete() {
		try {
			pacienteDAO.insert(paciente);
			assertEquals(1, pacienteDAO.delete(paciente));
			assertEquals(0, pacienteDAO.delete(paciente));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

}
