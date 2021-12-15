package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class AgenteBDTest {

	private final static String SELECT_SQL = "SELECT * FROM  pacientes";
	private final static String INSERT_SQL = "INSERT INTO pacientes VALUES('21715362G', 6, 6 , 'Roberto', 'Esteban', 'False')";
	private final static String DELETE_SQL = "DELETE FROM pacientes WHERE dni = '21715362G'";
	private final static String UPDATE_SQL = "UPDATE pacientes SET dni = '21715362G', grupo = 6, region = 7, nombre = 'Roberto', apellidos = 'Esteban Olivares', segunda_dosis = 'False' WHERE dni = '21715362G'";

	private final static String SELECT_SQL_EXCEPTION = "SELECT * FROM coches";
	private final static String INSERT_SQL_EXCEPTION = "INSERT INTO pacientes VALUES('21715362G',seis, 6 , 'Roberto', 'Esteban', 'False')";
	private final static String DELETE_SQL_EXCEPTION = "DELETE FROM pacientes WHERE adni = '21715362G'";
	private final static String UPDATE_SQL_EXCEPTION = "UPDATE pacientes SET dni = '21715362G', grupo = 6, region = 7, nombre = 'Roberto', apellidos = 'Esteban Olivares', segunda_dosis = 'False' WHERE adni = '21715362G'";

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
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
	final void testAgenteBD() {
		try {
			AgenteBD agente = new AgenteBD();
			assertTrue(agente instanceof AgenteBD);
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

	@Test
	final void testGetAgente() {
		try {
			AgenteBD agente = AgenteBD.getAgente();
			assertNotNull(agente);
			assertTrue(agente instanceof AgenteBD);
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

	@Test
	final void testConectarBD() {
		try {
			AgenteBD.conectarBD();
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

	@Test
	final void testDesconectarBD() {
		try {
			AgenteBD agente = AgenteBD.getAgente();
			agente.desconectarBD();
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

	@Test
	final void testSelect() throws SQLException {
		try {
			assertEquals(0, AgenteBD.getAgente().select(SELECT_SQL).size());
			AgenteBD.getAgente().insert(INSERT_SQL);
			assertEquals(1, AgenteBD.getAgente().select(SELECT_SQL).size());
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					AgenteBD.getAgente().select(SELECT_SQL_EXCEPTION);
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			AgenteBD.getAgente().delete(DELETE_SQL);
		}
	}

	@Test
	final void testInsert() throws SQLException {
		try {
			assertEquals(1, AgenteBD.getAgente().insert(INSERT_SQL));
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					AgenteBD.getAgente().insert(INSERT_SQL);
				}
			});
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					AgenteBD.getAgente().insert(INSERT_SQL_EXCEPTION);
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			AgenteBD.getAgente().delete(DELETE_SQL);
		}
	}

	@Test
	final void testUpdate() throws SQLException {
		try {
			AgenteBD.getAgente().insert(INSERT_SQL);
			assertEquals(1, AgenteBD.getAgente().update(UPDATE_SQL));
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					AgenteBD.getAgente().update(UPDATE_SQL_EXCEPTION);
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			AgenteBD.getAgente().delete(DELETE_SQL);
		}
	}

	@Test
	final void testDelete() {
		try {
			AgenteBD.getAgente().insert(INSERT_SQL);
			assertEquals(1, AgenteBD.getAgente().delete(DELETE_SQL));
			assertEquals(0, AgenteBD.getAgente().delete(DELETE_SQL));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
		assertThrows(SQLException.class, new Executable() {
			@Override
			public void execute() throws Exception {
				AgenteBD.getAgente().delete(DELETE_SQL_EXCEPTION);
			}
		});
	}

}
