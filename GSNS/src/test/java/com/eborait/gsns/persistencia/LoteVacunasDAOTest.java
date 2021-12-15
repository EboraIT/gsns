package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.eborait.gsns.dominio.controller.Util;
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
		lote = new LoteVacunas("1", fecha, tipo, 4500, "Moderna");
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	void testGet() throws SQLException {
		try {
			lotevacunasDAO.insert(lote);
			LoteVacunas loteDevuelta = lotevacunasDAO.get("1");
			assertEquals(lote, loteDevuelta);
			assertNull(lotevacunasDAO.get("id_falso"));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
		}
	}

	@Test
	void testGetAll() throws SQLException {
		LoteVacunas lote2 = null;
		try {
			lotevacunasDAO.insert(lote);
			lote2 = new LoteVacunas("2", fecha, tipo, 4500, "Moderna");
			lotevacunasDAO.insert(lote2);
			Collection<LoteVacunas> lotes = lotevacunasDAO.getAll(null, null);
			Iterator<LoteVacunas> it = lotes.iterator();
			assertEquals(lote, it.next());
			assertEquals(lote2, it.next());
			lotes = lotevacunasDAO.getAll("id", "2");
			assertEquals(lote2, lotes.iterator().next());
			assertThrows(Exception.class, new Executable() {
				@Override
				public void execute() throws Exception {
					lotevacunasDAO.getAll("columna_falsa", "");
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
			lotevacunasDAO.delete(lote2);
		}
	}

	@Test
	void testInsert() throws SQLException {
		try {
			assertEquals(1, lotevacunasDAO.insert(lote));
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					lotevacunasDAO.insert(lote);
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
		}
	}

	@Test
	void testUpdate() throws SQLException {
		try {
			lotevacunasDAO.insert(lote);
			lote.setCantidad(4501);
			assertEquals(1, lotevacunasDAO.update(lote));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
		}
	}

	@Test
	void testDelete() {
		try {
			lotevacunasDAO.insert(lote);
			assertEquals(1, lotevacunasDAO.delete(lote));
			assertEquals(0, lotevacunasDAO.delete(lote));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

	@Test
	void testMaxId() throws SQLException {
		LoteVacunas lote2 = null;
		try {
			lotevacunasDAO.insert(lote);
			lote2 = new LoteVacunas("2", fecha, tipo, 7000, "Moderna");
			lotevacunasDAO.insert(lote2);
			assertEquals(2, lotevacunasDAO.maxId());
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			lotevacunasDAO.delete(lote);
			lotevacunasDAO.delete(lote2);
		}
	}

}
