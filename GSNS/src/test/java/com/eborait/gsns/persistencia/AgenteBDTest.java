package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgenteBDTest {

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
	final void testSelect() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	final void testInsert() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	final void testUpdate() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	final void testDelete() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

}
