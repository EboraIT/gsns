package com.eborait.gsns.dominio.entitymodel;

import java.util.Collection;
import java.util.Date;

public class LoteVacunas {

	private Collection<EntregaVacunas> entregas;
	private TipoVacuna tipo;
	private String id;
	private Date fecha;
	private int cantidad;
	private String farmaceutica;

	public LoteVacunas(Date fecha, String tipo, int cantidad) {
		// TODO Auto-generated constructor stub
	}

	public Collection<EntregaVacunas> getEntregas() {
		return entregas;
	}

	public void setEntregas(Collection<EntregaVacunas> entregas) {
		this.entregas = entregas;
	}

	public TipoVacuna getTipo() {
		return tipo;
	}

	public void setTipo(TipoVacuna tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}

	@Override
	public String toString() {
		return "LoteVacunas [entregas=" + entregas + ", tipo=" + tipo + ", id="
				+ id + ", fecha=" + fecha + ", cantidad=" + cantidad + ", farmaceutica=" + farmaceutica + "]";
	}

}