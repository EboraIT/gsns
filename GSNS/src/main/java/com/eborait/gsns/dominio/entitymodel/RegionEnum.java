package com.eborait.gsns.dominio.entitymodel;

import java.util.*;

public enum RegionEnum {
	AND(1, "Andalucia"), AR(2, "Aragón"), AST(3, "Asturias"), CEU(4, "Ceuta"), CAN(5, "Cantabria"),
	CLM(6, "Castilla-La Mancha"), CYL(7, "Castilla y Leon"), CAT(8, "Cataluña"), MAD(9, "Comunidad de Madrid"),
	VAL(10, "Comunidad Valenciana"), EUS(9, "Euskadi"), EXT(10, "Extremadura"), GAL(11, "Galicia"),
	BAL(12, "Islas Baleares"), ICA(13, "Islas Canarias"), RIO(14, "La Rioja"), MEL(15, "Melilla"), NAV(16, "Navarra"),
	MUR(17, "Región de Murcia");

	private Collection<EntregaVacunas> entregas;
	private final int id;
	private final String nombre;

	private RegionEnum(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.entregas = new ArrayList<>();
	}

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public static RegionEnum valueOf(int id) {
		for (RegionEnum re : values()) {
			if (re.getId() == id) {
				return re;
			}
		}
		// TODO cambiar excepcion por una registrada o propia
		throw new IllegalArgumentException("La región no existe.");
	}

	public static String[] getNombres() {
		String[] nombres = new String[values().length];
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = values()[i].getNombre();
		}
		return nombres;
	}

}