package com.eborait.gsns.dominio.entitymodel;

import java.util.*;

public enum RegionEnum{
	GALICIA,ASTURIAS,CANTABRIA,EUSKADI,NAVARRA,LARIOJA, ARAGON, CATALUÑA,CASTILLAYLEON,CMADRID,CASTILLALAMANCHA,CVALENCIANA
	,EXTREMADURA,ANDAUCIA,RMURCIA,IBALEARES,ICANARIAS,CEUTA,MELILLA;
	Collection<EntregaVacunas> entregas;

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

	
}