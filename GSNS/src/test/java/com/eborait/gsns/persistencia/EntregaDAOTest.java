package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

class EntregaDAOTest {

	private static EntregaDAO entregaDAO;
	private Date fecha;
	private TipoVacuna vacuna;
	private EntregaVacunas entrega;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		entregaDAO = DAOFactory.getEntregaDAO();
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
		fecha = Util.parseFecha("2/12/2021");
		vacuna = new TipoVacuna("Pfizer", "Moderna", "23/11/2021");
		entrega = new EntregaVacunas("loteVacuna001", "Lote1", fecha, 2333, 1, vacuna, 6);
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	final void testGet() throws SQLException {
		try {
			entregaDAO.insert(entrega);
			EntregaVacunas entregaDevuelta = entregaDAO.get("loteVacuna001");
			assertEquals(entrega, entregaDevuelta);
			assertThrows(Exception.class, new Executable() {
				@Override
				public void execute() throws Exception {
					entregaDAO.get("id_falso");
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			entregaDAO.delete(entrega);
		}
	}

	@Test
	final void testGetAll() throws GSNSException, SQLException {
		EntregaVacunas entrega2 = null;
		try {
			entregaDAO.insert(entrega);
			entrega2 = new EntregaVacunas("loteVacuna002", "Lote1", fecha, 2333, 1, vacuna, 6);
			entregaDAO.insert(entrega2);
			Collection<EntregaVacunas> entregas = entregaDAO.getAll(null, null);
			Iterator<EntregaVacunas> it = entregas.iterator();
			assertEquals(entrega, it.next());
			assertEquals(entrega2, it.next());
			entregas = entregaDAO.getAll("id", "loteVacuna002");
			assertEquals(entrega2, entregas.iterator().next());
			assertThrows(Exception.class, new Executable() {
				@Override
				public void execute() throws Exception {
					entregaDAO.getAll("columna_falsa", "");
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			entregaDAO.delete(entrega);
			entregaDAO.delete(entrega2);
		}
	}

	@Test
	final void testInsert() throws SQLException {
		try {
			assertEquals(1, entregaDAO.insert(entrega));
			assertThrows(SQLException.class, new Executable() {
				@Override
				public void execute() throws Exception {
					entregaDAO.insert(entrega);
				}
			});
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			entregaDAO.delete(entrega);
		}
	}

	@Test
	final void testUpdate() throws SQLException {
		try {
			entregaDAO.insert(entrega);
			entrega.setCantidad(4501);
			assertEquals(1, entregaDAO.update(entrega));
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		} finally {
			entregaDAO.delete(entrega);
		}
	}

	@Test
	final void testDelete() {
		try {
			entregaDAO.insert(entrega);
			assertEquals(1, entregaDAO.delete(entrega));
			assertEquals(0, entregaDAO.delete(entrega));
			// TODO UPDATE
		} catch (SQLException sqle) {
			fail("Excepción SQLException no esperada.");
		}
	}

}
