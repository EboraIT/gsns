package com.eborait.gsns.dominio.entitymodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.eborait.gsns.dominio.entitymodel.excepciones.GSNSException;

public class EntregaVacunas {

	private String id;
	private TipoVacuna tipo;
	private RegionEnum region;
	private GrupoPrioridad grupoPrioridad;
	private LoteVacunas lote;
	private Date fecha;
	private int cantidad;

	public EntregaVacunas(String id, String lote, String fecha, int cantidad, int prioridad, TipoVacuna tipo,
			int region) throws ParseException, GSNSException {
		this.id = id;
		this.fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		this.lote = new LoteVacunas(lote, this.fecha, tipo, cantidad, tipo.getFarmaceutica());
		this.cantidad = cantidad;
		this.grupoPrioridad = GrupoPrioridad.valueOf(prioridad);
		this.tipo = tipo;
		this.region = RegionEnum.valueOf(region);

		this.region.getEntregas().add(this);
		this.grupoPrioridad.getEntregas().add(this);
		this.lote.getEntregas().add(this);
	}

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
			System.out.println(gsnse.getMessage());
			gsnse.printStackTrace();
		}
		this.lote.getEntregas().add(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

}