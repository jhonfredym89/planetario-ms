package com.trycore.planetario.microservicio.dominio.personas.modelo.entidades;

import java.util.Date;

public class PersonaTestDataBuilder {
	private int numeroIdentificacion;
	private String nombre;
	private Date fechaNacimiento;
	private String genero;
	private Float estaturaEnMetros;
	private Float pesoEnKilogramos;
	private Integer cantidadVisitas;
	private String planeta;

	public PersonaTestDataBuilder() {
		numeroIdentificacion = 123;
		nombre = "Jhon";
		fechaNacimiento = new Date();
		genero = "M";
		estaturaEnMetros = 1.66F;
		pesoEnKilogramos = 91.7F;
		cantidadVisitas = 10;
		planeta = "Tierra";
	}

	public PersonaTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public PersonaTestDataBuilder conCantidadVisitas(Integer cantidadVisitas) {
		this.cantidadVisitas = cantidadVisitas;
		return this;
	}

	public Persona construir() {
		return new Persona(numeroIdentificacion, nombre, fechaNacimiento, genero, estaturaEnMetros, pesoEnKilogramos,
				cantidadVisitas, planeta);
	}
}
