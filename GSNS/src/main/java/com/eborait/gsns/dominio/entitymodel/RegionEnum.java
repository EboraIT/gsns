package com.eborait.gsns.dominio.entitymodel;

import java.util.ArrayList;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public enum RegionEnum {
	AND(1, "Andalucia",8501450), AR(2, "Aragón",1331280), AST(3, "Asturias",1013018), CEU(4, "Ceuta",83502), CAN(5, "Cantabria",583904),
	CLM(6, "Castilla-La Mancha",2049455), CYL(7, "Castilla y Leon",2387370), CAT(8, "Cataluña",7669999), MAD(9, "Comunidad de Madrid",6752763),
	VAL(10, "Comunidad Valenciana",5045885), VAS(9, "Pais Vasco",2185605), EXT(10, "Extremadura",1057999), GAL(11, "Galicia",2696995),
	BAL(12, "Islas Baleares",1219423), ICA(13, "Islas Canarias",2244423), RIO(14, "La Rioja",316197), MEL(15, "Melilla",84019), NAV(16, "Navarra",657776),
	MUR(17, "Región de Murcia",1513161);

	private Collection<EntregaVacunas> entregas;
	private final int id;
	private final String nombre;
	private final int poblacion;

	private RegionEnum(int id, String nombre,int poblacion) {
		this.id = id;
		this.nombre = nombre;
		this.poblacion=poblacion;
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

	public int getPoblacion() {
		return poblacion;
	}

	public static RegionEnum valueOf(int id) throws GSNSException {
		for (RegionEnum re : values()) {
			if (re.getId() == id) {
				return re;
			}
		}
		throw new GSNSException("La región no existe.");
	}

	public static String[] getNombres() {
		String[] nombres = new String[values().length];
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = values()[i].getNombre();
		}
		return nombres;
	}

}