package com.trycore.planetario.microservicio.dominio.planetas.modelo.entidades;

public class PlanetaTestDataBuilder {

	private String nombre;
	private float periodoRotacion;
	private int diametro;
	private String terreno;
	private String clima;
	private Integer cantidadVisitas;

	public PlanetaTestDataBuilder() {
		nombre = "Tierra";
		periodoRotacion = 1;
		diametro = 12756;
		terreno = "Rocoso";
		clima = "Calido";
		cantidadVisitas = 10;
	}

	public PlanetaTestDataBuilder conCantidadVisitas(Integer cantidadVisitas) {
		this.cantidadVisitas = cantidadVisitas;
		return this;
	}

	public Planeta construir() {
		return new Planeta(nombre, periodoRotacion, diametro, terreno, clima, cantidadVisitas);
	}
}
