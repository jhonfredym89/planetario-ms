package com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos;

import java.util.List;

public class PlanetaDTO {
	private String nombre;
	private float periodoRotacion;
	private int diametro;
	private String terreno;
	private String clima;
	private Integer cantidadVisitas;
	private List<String> personas;

	public PlanetaDTO(String nombre, float periodoRotacion, int diametro, String terreno, String clima,
			Integer cantidadVisitas, List<String> personas) {

		this.nombre = nombre;
		this.periodoRotacion = periodoRotacion;
		this.diametro = diametro;
		this.terreno = terreno;
		this.clima = clima;
		this.cantidadVisitas = cantidadVisitas;
		this.personas = personas;
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

	public List<String> getPersonas() {
		return personas;
	}
}
