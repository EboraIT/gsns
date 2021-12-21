package com.eborait.gsns.dominio.entitymodel;

import java.util.ArrayList;
import java.util.Collection;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

/**
 * Define la información relativa a regiones.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public enum RegionEnum {

	/** Andalucía. */
	AND(1, "Andalucia", 8501450),
	/** Aragón. */
	AR(2, "Aragón", 1331280),
	/** Asturias. */
	AST(3, "Asturias", 1013018),
	/** Ceuta. */
	CEU(4, "Ceuta", 83502),
	/** Cantabria. */
	CAN(5, "Cantabria", 583904),
	/** Castilla-La Mancha. */
	CLM(6, "Castilla-La Mancha", 2049455),
	/** Castilla y León. */
	CYL(7, "Castilla y León", 2387370),
	/** Cataluña. */
	CAT(8, "Cataluña", 7669999),
	/** Comunidad de Madrid. */
	MAD(9, "Comunidad de Madrid", 6752763),
	/** Comunidad Valenciana. */
	VAL(10, "Comunidad Valenciana", 5045885),
	/** País Vasco. */
	VAS(11, "País Vasco", 2185605),
	/** Extremadura. */
	EXT(12, "Extremadura", 1057999),
	/** Galicia. */
	GAL(13, "Galicia", 2696995),
	/** Islas Baleares. */
	BAL(14, "Islas Baleares", 1219423),
	/** Islas Canarias. */
	ICA(15, "Islas Canarias", 2244423),
	/** La Rioja. */
	RIO(16, "La Rioja", 316197),
	/** Melilla. */
	MEL(17, "Melilla", 84019),
	/** Navarra. */
	NAV(18, "Navarra", 657776),
	/** Región de Murcia. */
	MUR(19, "Región de Murcia", 1513161);

	/** Las entregas. */
	private final Collection<EntregaVacunas> entregas;

	/** El id. */
	private final int id;

	/** El nombre. */
	private final String nombre;

	/** La población. */
	private final int poblacion;

	/**
	 * Instancia una nueva región.
	 *
	 * @param id        El id.
	 * @param nombre    El nombre.
	 * @param poblacion La población.
	 */
	RegionEnum(int id, String nombre, int poblacion) {
		this.id = id;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.entregas = new ArrayList<>();
	}

	/**
	 * Se obtienen las entregas.
	 *
	 * @return Las entregas.
	 */
	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	/**
	 * Se obtiene el id.
	 *
	 * @return El id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Se obtiene el nombre.
	 *
	 * @return El nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Se obtiene la población.
	 *
	 * @return La población.
	 */
	public int getPoblacion() {
		return poblacion;
	}

	/**
	 * Se obtiene la región mediante su identificador.
	 *
	 * @param id El id.
	 * @return La región.
	 * @throws GSNSException Si la región no existe.
	 */
	public static RegionEnum valueOf(int id) throws GSNSException {
		for (RegionEnum re : values()) {
			if (re.getId() == id) {
				return re;
			}
		}
		throw new GSNSException("La región no existe.");
	}

	/**
	 * Se obtienen los nombres de las regiones en un array de tipo String.
	 *
	 * @return Los nombres de las regiones.
	 */
	public static String[] getNombres() {
		String[] nombres = new String[values().length];
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = values()[i].getNombre();
		}
		return nombres;
	}

}