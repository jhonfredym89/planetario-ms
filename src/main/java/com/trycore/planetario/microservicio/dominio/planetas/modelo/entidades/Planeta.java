package com.trycore.planetario.microservicio.dominio.planetas.modelo.entidades;

public class Planeta {
	
	private String nombre;
	private float periodoRotacion;
	private int diametro;
	private String terreno;
	private String clima;
	private Integer cantidadVisitas;

	public Planeta(String nombre, float periodoRotacion, int diametro, String terreno, String clima,
			Integer cantidadVisitas) {

		this.nombre = nombre;
		this.periodoRotacion = periodoRotacion;
		this.diametro = diametro;
		this.terreno = terreno;
		this.clima = clima;
		this.cantidadVisitas = cantidadVisitas;
	}

	public void sumarVisitas() {
		if (cantidadVisitas == null) {
			cantidadVisitas = 1;
		} else {
			cantidadVisitas++;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public float getPeriodoRotacion() {
		return periodoRotacion;
	}

	public int getDiametro() {
		return diametro;
	}

	public String getTerreno() {
		return terreno;
	}

	public String getClima() {
		return clima;
	}

	public Integer getCantidadVisitas() {
		return cantidadVisitas;
	}
}
