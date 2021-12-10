package com.eborait.gsns.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eborait.gsns.dominio.entitymodel.EntregaVacunas;
import com.eborait.gsns.dominio.entitymodel.TipoVacuna;
import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class EntregaDAOTest {
	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT = "SELECT * FROM entrega_vacunas WHERE id = '%s'";

	/**
	 * Formato sentencia select.
	 */
	private static final String SELECT_CRITERIA = "SELECT * FROM entrega_vacunas";

	/**
	 * Formato sentencia insert.
	 */
	private static final String INSERT = "INSERT INTO entrega_vacunas VALUES('%s', '%s', '%s', %s, %s, '%s', %s)";

	/**
	 * Formato sentencia update.
	 */
	private static final String UPDATE = "UPDATE entrega_vacunas SET id = '%s', lote = '%s', fecha = '%s', cantidad = %s, prioridad = %s, tipo_vacuna = '%s', region = %s WHERE id = '%s'";

	/**
	 * Formato sentencia delete.
	 */
	private static final String DELETE = "DELETE FROM entrega_vacunas WHERE id = '%s'";
	
	EntregaDAO entregaDAO = DAOFactory.getEntregaDAO();
	

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
	public void testGet() {
		// TODO
	}

	@Test
	public void testGetAll() {
		// TODO
	}

	@Test
	void testInsert() throws  ParseException, GSNSException, SQLException {
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
	    Date dt_1 = objSDF.parse("20-08-2021"); 
		TipoVacuna vacuna = new TipoVacuna("Pfizer","Moderna","23/11/2021");
		EntregaVacunas Entrega = new EntregaVacunas("loteVacuna001","Lote1" ,dt_1, 2333, 1, vacuna, 6); 
		try {

			assertEquals(1,entregaDAO.insert(Entrega));
		}catch(SQLException e) {
			fail("Excepción SQLException no esperada.");
			
		} finally {
			entregaDAO.delete(Entrega);
		}
	}

	@Test
	 void testUpdate() throws ParseException, GSNSException, SQLException {
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
	    Date dt_1 = objSDF.parse("20-08-2021"); 
		TipoVacuna vacuna = new TipoVacuna("Pfizer","Moderna","23/11/2021");
		EntregaVacunas Entrega = new EntregaVacunas("loteVacuna001","Lote1" ,dt_1, 2333, 1, vacuna, 6); 
		EntregaVacunas Entrega2 = new EntregaVacunas("loteVacuna001","Lote1" ,dt_1, 2333, 1, vacuna, 6); 
		
		try {

			entregaDAO.insert(Entrega);
			Entrega2.setCantidad(4501);
			//TODO UPDATE
		}catch(SQLException e) {
			fail("Excepción SQLException no esperada.");
			
		} finally {
			entregaDAO.delete(Entrega);
		}
	}

	@Test
	public void testDelete() {
		
		
	}

}
