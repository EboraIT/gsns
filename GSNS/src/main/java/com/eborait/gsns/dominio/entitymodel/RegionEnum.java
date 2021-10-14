package com.eborait.gsns.dominio.entitymodel;

import java.util.*;

public class RegionEnum{

	Collection<EntregaVacunas> entregas;

	public RegionEnum(Collection<EntregaVacunas> entregas) {
		super();
		this.entregas = entregas;
	}

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

	@Override
	public String toString() {
		return "RegionEnum [entregas=" + entregas + "]";
	}
	

}