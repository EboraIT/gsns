package com.eborait.gsns.dominio.controller;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class GestorVacunacionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAltaEntregaVacunas() {
		String id = "alta-1";
		String lote = "lote1";
		String fecha = "23/11/2021";
		int cantidad = 2000;
		int prioridad = 2;
		String Vacuna = "Pfizer";
		int region = 4;
		TipoVacuna tipoVacuna = new TipoVacuna(Vacuna);
		EntregaVacunas entregaVac = new EntregaVacunas(id,lote,Util.parseFecha(fecha),cantidad,prioridad,tipoVacuna,region);
		EntregaVacunas entregaVac2 = new EntregaVacunas(id,lote,Util.parseFecha("01-23-2021"),cantidad,prioridad,tipoVacuna,region);
		try {
			assertTrue(gestorGSNS.getEntregaDAO().insert(entregaVac)==1);
		} catch (GSNSException e) {
			fail("Excepcion inesperada "+e);
		}
		
		try {
			fail(gestorGSNS.getEntregaDAO().insert(entregaVac2)==1);
		} catch (GSNSException e) {
			fail("Excepcion inesperada (fecha mal) "+e);
		
		}
	}

}