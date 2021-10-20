package com.eborait.gsns.dominio.entitymodel;

import java.util.*;

public enum RegionEnum {
	AND, AR, AST, CEU, CAN, CLM, CYL, CAT, MAD,
	VAL, EUS, EXT, GAL, BAL, ICA, RIO, MEL, NAV,
	MUR;

	Collection<EntregaVacunas> entregas;

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

}