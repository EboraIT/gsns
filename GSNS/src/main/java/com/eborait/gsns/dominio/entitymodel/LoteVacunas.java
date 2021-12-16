package com.eborait.gsns.dominio.entitymodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Define la información relativa a un lote de vacunas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class LoteVacunas {

	/** Las entregas. */
	private Collection<EntregaVacunas> entregas;

	/** El tipo de vacuna. */
	private TipoVacuna tipo;

	/** El id. */
	private int id;

	/** La fecha. */
	private Date fecha;

	/** La cantidad. */
	private int cantidad;

	/** La farmacéutica. */
	private String farmaceutica;

	/**
	 * Instancia un nuevo lote de vacunas.
	 *
	 * @param id           El id.
	 * @param fecha        La fecha.
	 * @param tipo         El tipo de vacuna.
	 * @param cantidad     La cantidad.
	 * @param farmaceutica La farmacéutica.
	 */
	public LoteVacunas(int id, Date fecha, String tipo, int cantidad, String farmaceutica) {
		this(id, fecha, new TipoVacuna(tipo), cantidad, farmaceutica);
	}

	/**
	 * Instancia un nuevo lote de vacunas.
	 *
	 * @param id           El id.
	 * @param fecha        La fecha.
	 * @param tipo         El tipo de vacuna.
	 * @param cantidad     La cantidad.
	 * @param farmaceutica La farmacéutica.
	 */
	public LoteVacunas(int id, Date fecha, TipoVacuna tipo, int cantidad, String farmaceutica) {
		this.id = id;
		this.fecha = fecha;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.farmaceutica = farmaceutica;
		this.entregas = new ArrayList<>();
	}

	/**
	 * Se obtiene las entregas.
	 *
	 * @return Las entregas.
	 */
	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	/**
	 * Establece las entregas.
	 *
	 * @param entregas Las nuevas entregas.
	 */
	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

	/**
	 * Se obtiene el tipo de vacuna.
	 *
	 * @return El tipo de vacuna.
	 */
	public TipoVacuna getTipo() {
		return tipo;
	}

	/**
	 * Establece el tipo de vacuna.
	 *
	 * @param tipo El nuevo tipo de vacuna.
	 */
	public void setTipo(TipoVacuna tipo) {
		this.tipo = tipo;
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
	 * Establece El id.
	 *
	 * @param id El nuevo id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Se obtiene la fecha.
	 *
	 * @return La fecha.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece La fecha.
	 *
	 * @param fecha La nueva fecha.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Se obtiene la cantidad.
	 *
	 * @return La cantidad.
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece La cantidad.
	 *
	 * @param cantidad La nueva cantidad.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Se obtiene la farmacéutica.
	 *
	 * @return La farmacéutica.
	 */
	public String getFarmaceutica() {
		return farmaceutica;
	}

	/**
	 * Establece La farmacéutica.
	 *
	 * @param farmaceutica La nueva farmaceutica.
	 */
	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}

	@Override
	public boolean equals(Object obj) {
		LoteVacunas lv = (LoteVacunas) obj;
		if (lv != null) {
			return entregas.size() == lv.getEntregas().size() && tipo.equals(lv.getTipo()) && id == lv.getId()
					&& cantidad == lv.getCantidad() && farmaceutica.equals(lv.getFarmaceutica());
		} else {
			return false;
		}
	}
}