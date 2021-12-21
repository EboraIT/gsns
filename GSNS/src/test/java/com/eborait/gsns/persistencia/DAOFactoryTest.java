package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DAOFactoryTest {

	@Test
	final void testGetEntregaDAO() {
		EntregaDAO entregaDAO = DAOFactory.getEntregaDAO();
		assertNotNull(entregaDAO);
		assertTrue(entregaDAO instanceof EntregaDAO);
	}

	@Test
	final void testGetLoteVacunasDAO() {
		LoteVacunasDAO loteVacunasDAO = DAOFactory.getLoteVacunasDAO();
		assertNotNull(loteVacunasDAO);
		assertTrue(loteVacunasDAO instanceof LoteVacunasDAO);
	}

	@Test
	final void testGetVacunacionDAO() {
		VacunacionDAO vacunacionDAO = DAOFactory.getVacunacionDAO();
		assertNotNull(vacunacionDAO);
		assertTrue(vacunacionDAO instanceof VacunacionDAO);
	}

	@Test
	final void testGetPacienteDAO() {
		PacienteDAO pacienteDAO = DAOFactory.getPacienteDAO();
		assertNotNull(pacienteDAO);
		assertTrue(pacienteDAO instanceof PacienteDAO);
	}

}
