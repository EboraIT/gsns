package com.eborait.gsns.dominio.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.LoteVacunas;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;
import com.eborait.gsns.persistencia.DAOFactory;
import com.eborait.gsns.persistencia.EntregaDAO;
import com.eborait.gsns.persistencia.LoteVacunasDAO;

class GestorRepartoVacunasTest {
	private static GestorRepartoVacunas gestorRepartoVacunas;
	private static LoteVacunasDAO lotevacunasDAO;
	private static EntregaDAO entregavacunasDAO;
	private static TipoVacuna tipovacuna;
	private static LoteVacunas lote;
	private static LoteVacunas lote2;
	private static Date fecha;
	private static int region2;
	private static EntregaVacunas entrega;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		fecha = Util.parseFecha("2/12/2021");
		tipovacuna = new TipoVacuna("Pfizer", "Moderna", "23/11/2021");
		lote = new LoteVacunas(1, fecha, tipovacuna, 4500, "Moderna");
		lote2 = new LoteVacunas(2, fecha, tipovacuna, 4500, "Moderna");
		entrega = new EntregaVacunas("loteVacuna001", 1, fecha, 2333, 1, tipovacuna, 6);
		region2 = entrega.getRegion().getId();
		lotevacunasDAO = DAOFactory.getLoteVacunasDAO();
		gestorRepartoVacunas = new GestorRepartoVacunas(new GestorGSNS());
		entregavacunasDAO = DAOFactory.getEntregaDAO();
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
	void testAltaNuevoLoteVacunas() throws GSNSException, SQLException {
		try {
			assertTrue(gestorRepartoVacunas.altaNuevoLoteVacunas(lote.getId(), "2/12/2021", lote.getCantidad(),
					lote.getTipo().getNombre(), lote.getFarmaceutica(), "23/11/2021"));
			assertThrows(GSNSException.class, new Executable() {
				@Override
				public void execute() throws GSNSException {
					gestorRepartoVacunas.altaNuevoLoteVacunas(lote.getId(), "2/12/2021", lote.getCantidad(),
							lote.getTipo().getNombre(), lote.getFarmaceutica(), "23/11/2021");
				}
			});
		} catch (GSNSException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
		}

	}

	@Test
	void testAltaNuevoLoteVacunasFallo() throws GSNSException, SQLException {
		try {
			assertTrue(gestorRepartoVacunas.altaNuevoLoteVacunas(lote.getId(), "2/12/2021", lote.getCantidad(), " ",
					lote.getFarmaceutica(), "23/11-2021"));
			
		} catch (GSNSException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
		}

	}

	@Test
	final void testCalcularEntregasRegion() throws SQLException {
		try {
			entregavacunasDAO.insert(entrega);
			gestorRepartoVacunas.altaNuevoLoteVacunas(lote.getId(), "2/12/2021", lote.getCantidad(),
					lote.getTipo().getNombre(), lote.getFarmaceutica(), "23/11/2021");
			assertEquals(1229676, gestorRepartoVacunas.calcularEntregasRegion(region2, 240));
			assertEquals(1230606, gestorRepartoVacunas.calcularEntregasRegion(region2, 0));
			assertThrows(GSNSException.class, new Executable() {
				@Override
				public void execute() throws GSNSException {
					assertEquals(1230606, gestorRepartoVacunas.calcularEntregasRegion(-15, 0));
				}
			});
		} catch (GSNSException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
			entregavacunasDAO.delete(entrega);
		}
	}

	@Test
	final void testGetTipoVacunas() throws SQLException, GSNSException {
		try {
			lotevacunasDAO.insert(lote);
			String[] lotes = { "Pfizer-Moderna-23/11/2021" };
			String[] lotesMal = { "Pfizer-Pfizer-23/11/2021" };
			assertArrayEquals(lotes, gestorRepartoVacunas.getTipoVacunas());
			assertFalse(Arrays.equals(lotesMal, gestorRepartoVacunas.getTipoVacunas()));
		} catch (GSNSException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
		}
	}

	@Test
	final void testGenerarIdLote() throws GSNSException, SQLException {
		try {
			lotevacunasDAO.insert(lote2);
			int id = lote2.getId() + 1;
			assertEquals(id, gestorRepartoVacunas.generarIdLote());
			assertNotEquals(id - 1, gestorRepartoVacunas.generarIdLote());
		} catch (GSNSException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote2);
		}
	}

}
