package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DAOFactoryTest {

	@Test
	final void testGetEntregaDAO() {
		EntregaDAO entregaDAO = DAOFactory.getEntregaDAO();
		assertTrue(entregaDAO instanceof EntregaDAO);
	}

	@Test
	final void testGetLoteVacunasDAO() {
		LoteVacunasDAO loteVacunasDAO = DAOFactory.getLoteVacunasDAO();
		assertTrue(loteVacunasDAO instanceof LoteVacunasDAO);
	}

	@Test
	final void testGetVacunacionDAO() {
		VacunacionDAO vacunacionDAO = DAOFactory.getVacunacionDAO();
		assertTrue(vacunacionDAO instanceof VacunacionDAO);
	}

	@Test
	final void testGetPacienteDAO() {
		PacienteDAO pacienteDAO = DAOFactory.getPacienteDAO();
		assertTrue(pacienteDAO instanceof PacienteDAO);
	}

}
