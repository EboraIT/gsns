package com.eborait.gsns.dominio.entitymodel;

import java.util.*;

public enum RegionEnum {
	ANDALUCIA, ARAGON, ASTURIAS, CEUTA, CANTABRIA, CASTILLA_LA_MANCHA, CASTILLA_Y_LEON, CATALUNA, COMUNIDAD_MADRID,
	COMUNIDAD_VALENCIANA, EUSKADI, EXTREMADURA, GALICIA, ISLAS_BALEARES, ISLAS_CANARIAS, LA_RIOJA, MELILLA, NAVARRA,
	REGION_DE_MURCIA;

	Collection<EntregaVacunas> entregas;

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

}