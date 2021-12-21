package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilTest {

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
	final void testGetSQLCriteria() {
		assertEquals("SELECT * FROM entrega_vacunas WHERE id = 1",
				Util.getSQLCriteria("SELECT * FROM entrega_vacunas", "id", "1"));
		assertEquals("SELECT * FROM entrega_vacunas WHERE id = 'asdf'",
				Util.getSQLCriteria("SELECT * FROM entrega_vacunas", "id", "asdf"));
		assertEquals("SELECT * FROM entrega_vacunas", Util.getSQLCriteria("SELECT * FROM entrega_vacunas", null, null));
	}

}
