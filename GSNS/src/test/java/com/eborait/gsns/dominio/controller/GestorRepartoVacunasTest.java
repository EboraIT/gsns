package com.eborait.gsns.dominio.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import com.eborait.gsns.persistencia.DAOFactory;
import com.eborait.gsns.persistencia.LoteVacunasDAO;
import com.eborait.gsns.persistencia.PacienteDAO;

 class GestorRepartoVacunasTest {
	private static GestorRepartoVacunas gestorRepartoVacunas;
	private static LoteVacunasDAO lotevacunasDAO;
	private TipoVacuna tipovacuna;
	private LoteVacunas lote;
	private Date fecha;
	private  GestorGSNS gestorGSNS;

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
		tipovacuna = new TipoVacuna("Pfizer", "Moderna","23/11/2021");
		lote = new LoteVacunas("loteVacuna001", fecha, tipovacuna, 4500, "Moderna");
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	 void testGestorRepartoVacunas() {
		//TODO
	}

	@Test
	 void testAltaNuevoLoteVacunas() throws GSNSException, SQLException {
		try {
			assertTrue(gestorRepartoVacunas.altaNuevoLoteVacunas("loteVacuna001","23/11/2021",4500, "Pfizer","Pfizer-Moderna","10/02/2020"));
			
		}catch (GSNSException e) {
			fail("Excepción SQLException no esperada.");
			
		}finally {
			lotevacunasDAO.delete(lote);
		}
		
	}

	@Test
	public void testCalcularEntregasRegion() {
		// TODO
	}

	@Test
	public void testGetTipoVacunas() {
		// TODO
	}

	@Test
	public void testGenerarIdLote() {
		// TODO
	}

}
