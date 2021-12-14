package com.eborait.gsns.dominio.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
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
	private static Date fecha;
	private static int region2;
	private static int ia;
	private static EntregaVacunas entrega;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		fecha = Util.parseFecha("2/12/2021");
		tipovacuna = new TipoVacuna("Pfizer", "Moderna", "23/11/2021");
		lote = new LoteVacunas("loteVacuna001", fecha, tipovacuna, 4500, "Moderna");
		entrega = new EntregaVacunas("loteVacuna001", "Lote1", fecha, 2333, 1, tipovacuna, 6);
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
				public void execute() throws Exception {
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
	final void testCalcularEntregasRegion() throws SQLException {
		/*try {
			entregavacunasDAO.insert(entrega);
			gestorRepartoVacunas.altaNuevoLoteVacunas(lote.getId(), "2/12/2021", lote.getCantidad(),
					lote.getTipo().getNombre(), lote.getFarmaceutica(), "23/11/2021");
			assertEquals(1229673, gestorRepartoVacunas.calcularEntregasRegion(region2, 240));
		} catch (GSNSException e) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
			entregavacunasDAO.delete(entrega);
		}*/
	}

	@Test
	final void testGetTipoVacunas() {
		// TODO
	}

	@Test
	final void testGenerarIdLote() throws GSNSException, SQLException {
		// TODO
	}

}
