package com.eborait.gsns.dominio.entitymodel;

import java.util.*;

public enum RegionEnum {
	AND(1,"Andalucia"), AR(2,"Aragon"), AST(3,"Asturias"), CEU(4,"Ceuta"), CAN(5,"Cantabria"), CLM(6,"Castilla-La Mancha"), 
	CYL(7,"Castilla y Leon"), CAT(8,"Cataluña"), MAD(9,"Comunidad de Madrid"),
	VAL(10,"Comunidad Valenciana"), EUS(9,"Euskadi"), EXT(10,"Extremadura"), GAL(11,"Galicia"), BAL(12,"Islas Baleares"), 
	ICA(13,"Islas Canarias"), RIO(14,"La Rioja"), MEL(15,"Melilla"), NAV(16,"Navarra"),
	MUR(17,"Region de Murcia");

	Collection<EntregaVacunas> entregas;
	private final int id;
	private final String nombre;

	private RegionEnum(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

}