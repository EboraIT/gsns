package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	String select="Select * from  pacientes";
	String insertsql="INSERT INTO pacientes VALUES('21715362G', 6, 6 , 'Roberto', 'Esteban', 'False')";
	String deletesql="DELETE FROM pacientes WHERE dni = '21715362G'";
	String updatesql="UPDATE pacientes SET dni = '21715362G', grupo = 6, region = 7, nombre = 'Roberto', apellidos = 'Esteban Olivares', segunda_dosis = 'False' WHERE dni = '21715362G'";
	
	String selectException="Select * from coches";
	String insertsql2="INSERT INTO pacientes VALUES('21715362G',seis, 6 , 'Roberto', 'Esteban', 'False')";
	String deletesql2="DELETE FROM pacientes WHERE dni = '21715362H'";
	String updatesql2="UPDATE pacientes SET dni = '21715362G', grupo = 6, region = 7, nombre = 'Roberto', apellidos = 'Esteban Olivares', segunda_dosis = 'False' WHERE dni = '21715362H'";
	
	

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
		AgenteBD agente = new AgenteBD();
		try {
			agente.delete(deletesql);
			assertEquals(1,agente.insert(insertsql));
		}catch(Exception e){
			assertEquals(1,agente.insert(insertsql));
		}finally {
			agente.delete(deletesql);
		}
		
		
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
		
		AgenteBD agente=null;
		try {
			agente = new AgenteBD();
			agente.insert(insertsql);
			assertEquals(1,agente.select(select).size());
			
		} catch (SQLException e) {
			fail("Excepción SQLException no esperada.");
		}finally {
			
			agente.delete(deletesql);
		}
		
	}

	@Test
	final void testInsert() throws SQLException {
		AgenteBD agente=null;
		try {
			agente = new AgenteBD();
			assertEquals(1,agente.insert(insertsql));
			
		} catch (SQLException e) {
			fail("Excepción SQLException no esperada.");
		}finally {
			
			agente.delete(deletesql);
		}
	}
	
	
	@Test
	final void testUpdate() throws SQLException {
		AgenteBD agente=null;
		try {
			agente = new AgenteBD();
			agente.insert(insertsql);
			assertEquals(1,agente.update(updatesql));
			
		} catch (SQLException e) {
			fail("Excepción SQLException no esperada.");
		}finally {
			
			agente.delete(deletesql);
		}
	}

	@Test
	final void testDelete() {
		AgenteBD agente=null;
		try {
			agente = new AgenteBD();
			agente.insert(insertsql);
			assertEquals(1,agente.delete(deletesql));
			
		} catch (SQLException e) {
			fail("Excepción SQLException no esperada.");
		}finally {
			
		}
	}

}
