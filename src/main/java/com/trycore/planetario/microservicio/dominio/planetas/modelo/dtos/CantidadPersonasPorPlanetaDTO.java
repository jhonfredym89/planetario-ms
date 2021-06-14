package com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos;

public class CantidadPersonasPorPlanetaDTO {
	private String planeta;
	private long cantidadPersonas;

	public CantidadPersonasPorPlanetaDTO(String planeta, long cantidadPersonas) {
		this.planeta = planeta;
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getPlaneta() {
		return planeta;
	}

	public long getCantidadPersonas() {
		return cantidadPersonas;
	}
}
