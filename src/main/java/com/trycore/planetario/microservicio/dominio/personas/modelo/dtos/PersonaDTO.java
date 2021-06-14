package com.trycore.planetario.microservicio.dominio.personas.modelo.dtos;

import java.util.Date;

public class PersonaDTO {

	private int numeroIdentificacion;
	private String nombre;
	private Date fechaNacimiento;
	private int edad;
	private String genero;
	private Float estatura;
	private Float peso;
	private Integer cantidadVisitas;
	private String planeta;

	public PersonaDTO(int numeroIdentificacion, String nombre, Date fechaNacimiento, String genero, Float estatura,
			Float peso, Integer cantidadVisitas, String planeta) {

		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.estatura = estatura;
		this.peso = peso;
		this.cantidadVisitas = cantidadVisitas;
		this.planeta = planeta;
	}

	public PersonaDTO(int numeroIdentificacion, String nombre, Date fechaNacimiento, int edad, String genero,
			Float estatura, Float peso, Integer cantidadVisitas, String planeta) {

		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.genero = genero;
		this.estatura = estatura;
		this.peso = peso;
		this.cantidadVisitas = cantidadVisitas;
		this.planeta = planeta;
	}

	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public String getGenero() {
		return genero;
	}

	public Float getEstatura() {
		return estatura;
	}

	public Float getPeso() {
		return peso;
	}

	public Integer getCantidadVisitas() {
		return cantidadVisitas;
	}

	public String getPlaneta() {
		return planeta;
	}
}
