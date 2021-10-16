package com.eborait.gsns.dominio.entitymodel;

import java.util.Date;

import com.eborait.gsns.persistencia.EntregaDAO;

public class EntregaVacunas {

	private TipoVacuna tipo;
	private RegionEnum region;
	private GrupoPrioridad grupoPrioridad;
	private LoteVacunas lote;
	private EntregaDAO entregaDao;
	private Date fecha;
	private int cantidad;

	public TipoVacuna getTipo() {
		return tipo;
	}

	public void setTipo(TipoVacuna tipo) {
		this.tipo = tipo;
	}

	public RegionEnum getRegion() {
		return region;
	}

	public void setRegion(RegionEnum region) {
		this.region = region;
	}

	public GrupoPrioridad getGrupoPrioridad() {
		return grupoPrioridad;
	}

	public void setGrupoPrioridad(GrupoPrioridad grupoPrioridad) {
		this.grupoPrioridad = grupoPrioridad;
	}

	public LoteVacunas getLote() {
		return lote;
	}

	public void setLote(LoteVacunas lote) {
		this.lote = lote;
	}

	public EntregaDAO getEntregaDao() {
		return entregaDao;
	}

	public void setEntregaDao(EntregaDAO entregaDao) {
		this.entregaDao = entregaDao;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "EntregaVacunas [tipo=" + tipo + ", region=" + region + ", grupoPrioridad=" + grupoPrioridad + ", lote="
				+ lote + ", entregaDao=" + entregaDao + ", fecha=" + fecha + ", cantidad=" + cantidad + "]";
	}

}