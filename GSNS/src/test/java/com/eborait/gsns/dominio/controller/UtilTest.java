package com.eborait.gsns.dominio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

class UtilTest {

	@Test
	final void testParseFechaCorrecta() {
		Date date = null;
		try {
			date = Util.parseFecha("11/12/2021");
		} catch (GSNSException e) {
			fail("Excepción GSNSException no esperada.");
		}
		assertEquals("Sat Dec 11 00:00:00 CET 2021", date.toString());
	}

	@Test
	final void testParseFechaIncorrecta() {
		assertThrows(GSNSException.class, new Executable() {
			@Override
			public void execute() throws Exception {
				Util.parseFecha("11-12-2021");
			}
		});
	}

}
