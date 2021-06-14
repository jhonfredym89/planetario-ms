package com.trycore.planetario.microservicio.dominio.personas.modelo.dtos;

public class PersonaInfoGeneralDTO {

	private int numeroIdentificacion;
	private String persona;
	private Integer cantidadVisitas;
	private String planeta;

	public PersonaInfoGeneralDTO(int numeroIdentificacion, String persona, Integer cantidadVisitas, String planeta) {
		this.numeroIdentificacion = numeroIdentificacion;
		this.persona = persona;
		this.cantidadVisitas = cantidadVisitas;
		this.planeta = planeta;
	}

	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public String getPersona() {
		return persona;
	}

	public Integer getCantidadVisitas() {
		return cantidadVisitas;
	}

	public String getPlaneta() {
		return planeta;
	}
}
