package com.eborait.gsns.dominio.entitymodel;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import com.eborait.gsns.persistencia.LoteVacunasDAO;

public class LoteVacunas {

	Collection<EntregaVacunas> entregas;
	TipoVacuna tipo;
	LoteVacunasDAO loteVacunasDao;
	private static String id;
	private static Date fecha;
	private static int cantidad;
	private static String farmaceutica;

	public LoteVacunas(Date fecha, String tipo, int cantidad) {
		// TODO Auto-generated constructor stub
	}

	public int insertar() throws SQLException {
		LoteVacunas LoteVacunas = null;
		return LoteVacunasDAO.insertarLoteVacunas(LoteVacunas);
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

	public LoteVacunasDAO getLoteVacunasDao() {
		return loteVacunasDao;
	}

	public void setLoteVacunasDao(LoteVacunasDAO loteVacunasDao) {
		this.loteVacunasDao = loteVacunasDao;
	}

	public static String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public static String getFarmaceutica() {
		return farmaceutica;
	}

	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}

	@Override
	public String toString() {
		return "LoteVacunas [entregas=" + entregas + ", tipo=" + tipo + ", loteVacunasDao=" + loteVacunasDao + ", id="
				+ id + ", fecha=" + fecha + ", cantidad=" + cantidad + ", farmaceutica=" + farmaceutica + "]";
	}

}