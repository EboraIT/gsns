package com.eborait.gsns.persistencia;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eborait.gsns.dominio.controller.Util;
import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;

 class LoteVacunasDAOTest {
	private static LoteVacunasDAO lotevacunasDAO;
	private Date fecha;
	private LoteVacunas lote;
	private TipoVacuna tipo;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		lotevacunasDAO = DAOFactory.getLoteVacunasDAO();
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
		fecha = Util.parseFecha("2/12/2021");
		tipo = new TipoVacuna("Pfizer", "Moderna", "23/11/2021");
		lote = new LoteVacunas("Lote1", fecha, "Pfizer", 4500, "Moderna");
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetAll() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testInsert() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testUpdate() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDelete() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testMax() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

}
