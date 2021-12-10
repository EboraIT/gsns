package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
		tipo = new TipoVacuna("Pfizer", "Moderna","23/11/2021");
		lote = new LoteVacunas("loteVacuna001", fecha, tipo, 4500, "Moderna");
	}
	
	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	 void testGet() throws SQLException  {
		//TODO
	}

	@Test
	public void testGetAll() {
		// TODO
		throw new RuntimeException("not yet implemented");
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
	public void testMax() {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

}
