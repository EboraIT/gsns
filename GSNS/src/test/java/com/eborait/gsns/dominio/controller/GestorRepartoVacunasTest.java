package com.eborait.gsns.dominio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.Paciente;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.Vacunacion;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class GestorRepartoVacunasTest {

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
	public void testAltaEntregaVacunas() throws GSNSException, SQLException {
		String id = "alta-1";
		String lote = "lote1";
		String fecha = "23/11/2021";
		int cantidad = 2000;
		int prioridad = 2;
		String Vacuna = "Pfizer";
		int region = 4;
		TipoVacuna tipoVacuna = new TipoVacuna(Vacuna);
		GestorGSNS gestorGSNS = new GestorGSNS();
		EntregaVacunas entregaVac = new EntregaVacunas(id,lote,Util.parseFecha(fecha),cantidad,prioridad,tipoVacuna,region);
		EntregaVacunas entregaVac2 = new EntregaVacunas(id,lote,Util.parseFecha("01-23-2021"),cantidad,prioridad,tipoVacuna,region);
		assertTrue(gestorGSNS.getEntregaDAO().insert(entregaVac)==1);
		
		
	}
	public void registrarVacunacion() throws GSNSException {
		String fecha= "12/11/2021";
		String nombre= "Alberto";
		String apellidos="Garcia Lopez";
		String nif="03263243T";
		String tipo="Pfizer";
		int prioridad=2;
		int region=2;
		boolean segundaDosis=false;
		GestorGSNS gestorGSNS = new GestorGSNS();
		Paciente paciente = new Paciente(nif, nombre, apellidos, prioridad, region, segundaDosis);
		Vacunacion vacunacion = new Vacunacion(0,new TipoVacuna(tipo), paciente, Util.parseFecha(fecha),
					segundaDosis);
		try {
			assertTrue(gestorGSNS.getVacunacionDAO().insert(vacunacion) == 1 && gestorGSNS.getPacienteDAO().insert(paciente) == 1);
		} catch (SQLException e) {
			fail("Excepcion inesperada  "+e);
		}
		
	}

}
