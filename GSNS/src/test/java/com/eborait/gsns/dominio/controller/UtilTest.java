package com.eborait.gsns.dominio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

class UtilTest {

	@Test
	final void testParseFech() throws ParseException {
		Date date = null;
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("11/12/2021");
		try {
			date = Util.parseFecha("11/12/2021");
		} catch (GSNSException e) {
			fail("Excepción GSNSException no esperada.");
		}
		assertEquals(0, date.compareTo(date2));
		assertThrows(GSNSException.class, new Executable() {
			@Override
			public void execute() throws Exception {
				Util.parseFecha("11-12-2021");
			}
		});
	}

}
