package com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos;

public class TopPlanetasDTO {
	private String planeta;
	private Integer cantidadVisitas;

	public TopPlanetasDTO(String planeta, Integer cantidadVisitas) {
		this.planeta = planeta;
		this.cantidadVisitas = cantidadVisitas;
	}

	public String getPlaneta() {
		return planeta;
	}

	public Integer getCantidadVisitas() {
		return cantidadVisitas;
	}
}
