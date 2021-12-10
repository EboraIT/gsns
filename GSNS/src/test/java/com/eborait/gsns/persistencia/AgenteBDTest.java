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

	private final static String selectSql = "SELECT * FROM  pacientes";
	private final static String insertSql = "INSERT INTO pacientes VALUES('21715362G', 6, 6 , 'Roberto', 'Esteban', 'False')";
	private final static String deleteSql = "DELETE FROM pacientes WHERE dni = '21715362G'";
	private final static String updateSql = "UPDATE pacientes SET dni = '21715362G', grupo = 6, region = 7, nombre = 'Roberto', apellidos = 'Esteban Olivares', segunda_dosis = 'False' WHERE dni = '21715362G'";

	private final static String selectException = "SELECT * FROM coches";
	private final static String insertSqlException = "INSERT INTO pacientes VALUES('21715362G',seis, 6 , 'Roberto', 'Esteban', 'False')";
	private final static String deleteSqlException = "DELETE FROM pacientes WHERE adni = '21715362G'";
	private final static String updateSqlException = "UPDATE pacientes SET dni = '21715362G', grupo = 6, region = 7, nombre = 'Roberto', apellidos = 'Esteban Olivares', segunda_dosis = 'False' WHERE adni = '21715362G'";

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
		AgenteBD agente = null;
		try {
			agente = new AgenteBD();
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
		assertTrue(agente instanceof AgenteBD);
	}

	@Test
	final void testGetAgente() {
		AgenteBD agente = null;
		try {
			agente = AgenteBD.getAgente();
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
		assertNotNull(agente);
		assertTrue(agente instanceof AgenteBD);
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
			assertEquals(0, AgenteBD.getAgente().select(selectSql).size());
			AgenteBD.getAgente().insert(insertSql);
			assertEquals(1, AgenteBD.getAgente().select(selectSql).size());
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					AgenteBD.getAgente().select(selectException);
				}
			});
		} catch (SQLException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			AgenteBD.getAgente().delete(deleteSql);
		}

	}

	@Test
	final void testInsert() throws SQLException {
		try {
			assertEquals(1, AgenteBD.getAgente().insert(insertSql));
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					AgenteBD.getAgente().insert(insertSql);
				}
			});
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					AgenteBD.getAgente().insert(insertSqlException);
				}
			});
		} catch (SQLException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			AgenteBD.getAgente().delete(deleteSql);
		}
	}

	@Test
	final void testUpdate() throws SQLException {
		try {
			AgenteBD.getAgente().insert(insertSql);
			assertEquals(1, AgenteBD.getAgente().update(updateSql));
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					AgenteBD.getAgente().update(updateSqlException);
				}
			});
		} catch (SQLException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			AgenteBD.getAgente().delete(deleteSql);
		}
	}

	@Test
	final void testDelete() {
		try {
			AgenteBD.getAgente().insert(insertSql);
			assertEquals(1, AgenteBD.getAgente().delete(deleteSql));
			assertEquals(0, AgenteBD.getAgente().delete(deleteSql));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
		assertThrows(SQLException.class, new Executable() {
			@Override
			public void execute() throws Exception {
				AgenteBD.getAgente().delete(deleteSqlException);
			}
		});
	}

}
