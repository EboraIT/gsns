package com.eborait.gsns.dominio.entitymodel;

import java.util.Date;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;


import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Define la información relativa a una entrega de vacunas.
 *
 * @author Jorge Fernández Escolano
 * @author Roberto Esteban Olivares
 * @version 1.0
 * @since 1.0
 */
public class EntregaVacunas {

	/** El id. */
	private String id;

	/** El tipo de vacuna. */
	private TipoVacuna tipo;

	/** La region. */
	private RegionEnum region;

	/** El grupo de prioridad. */
	private GrupoPrioridad grupoPrioridad;

	/** El lote de vacunas. */
	private LoteVacunas lote;

	/** La fecha. */
	private Date fecha;

	/** La cantidad. */
	private int cantidad;
	
	/** Objeto Logger. */
	private static final Logger LOG = Logger.getLogger(EntregaVacunas.class.getName());

	/**
	 * Instancia un objeto EntregaVacunas.
	 *
	 * @param id        El id.
	 * @param lote      El tipo de vacuna.
	 * @param fecha     La fecha.
	 * @param cantidad  La cantidad.
	 * @param prioridad La prioridad.
	 * @param tipo      El tipo de vacuna.
	 * @param region    La región.
	 * @throws GSNSException Si se produce una excepción en el grupo de prioridad o
	 *                       la región.
	 */
	public EntregaVacunas(String id, String lote, Date fecha, int cantidad, int prioridad, TipoVacuna tipo, int region)
			throws GSNSException {
		this.id = id;
		this.fecha = fecha;
		this.lote = new LoteVacunas(lote, fecha, tipo, cantidad, tipo.getFarmaceutica());
		this.cantidad = cantidad;
		this.grupoPrioridad = GrupoPrioridad.valueOf(prioridad);
		this.tipo = tipo;
		this.region = RegionEnum.valueOf(region);

		this.region.getEntregas().add(this);
		this.grupoPrioridad.getEntregas().add(this);
		this.lote.getEntregas().add(this);
	}

	/**
	 * Instancia un objeto EntregaVacunas.
	 *
	 * @param id        El id.
	 * @param lote      El tipo de vacuna.
	 * @param fecha     La fecha.
	 * @param cantidad  La cantidad.
	 * @param prioridad La prioridad.
	 * @param tipo      El tipo de vacuna.
	 * @param region    La región.
	 */
	public EntregaVacunas(String id, String lote, Date fecha, int cantidad, int prioridad, String tipo, int region) {
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.tipo = new TipoVacuna(tipo);
		this.lote = new LoteVacunas(lote, fecha, tipo, cantidad, this.tipo.getFarmaceutica());
		try {
			this.grupoPrioridad = GrupoPrioridad.valueOf(prioridad);
			this.region = RegionEnum.valueOf(region);

			this.region.getEntregas().add(this);
			this.grupoPrioridad.getEntregas().add(this);
		} catch (GSNSException gsnse) {
			LOG.log(Level.SEVERE, "{0}", "" + gsnse.getMessage());
			LOG.log(Level.SEVERE, "", gsnse);
		}
		this.lote.getEntregas().add(this);
	}

	/**
	 * Se obtiene el id.
	 *
	 * @return El id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el id.
	 *
	 * @param id El nuevo id.
	 */
	public void setId(String id) {
		this.id = id;
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
	 * Se obtiene la region.
	 *
	 * @return La region.
	 */
	public RegionEnum getRegion() {
		return region;
	}

	/**
	 * Establece la region.
	 *
	 * @param region La nueva region.
	 */
	public void setRegion(RegionEnum region) {
		this.region = region;
	}

	/**
	 * Se obtiene el grupo de prioridad.
	 *
	 * @return El grupo de prioridad.
	 */
	public GrupoPrioridad getGrupoPrioridad() {
		return grupoPrioridad;
	}

	/**
	 * Establece el grupo de prioridad.
	 *
	 * @param grupoPrioridad El nuevo grupo de prioridad.
	 */
	public void setGrupoPrioridad(GrupoPrioridad grupoPrioridad) {
		this.grupoPrioridad = grupoPrioridad;
	}

	/**
	 * Se obtiene el lote de vacunas.
	 *
	 * @return El lote de vacunas.
	 */
	public LoteVacunas getLote() {
		return lote;
	}

	/**
	 * Establece el lote de vacunas.
	 *
	 * @param lote El nuevo lote de vacunas.
	 */
	public void setLote(LoteVacunas lote) {
		this.lote = lote;
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
	 * Establece la fecha.
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
	 * Establece la cantidad.
	 *
	 * @param cantidad La nueva cantidad.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}