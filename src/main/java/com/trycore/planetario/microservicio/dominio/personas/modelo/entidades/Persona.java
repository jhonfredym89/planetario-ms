package com.trycore.planetario.microservicio.dominio.personas.modelo.entidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Persona {

	private int numeroIdentificacion;
	private String nombre;
	private Date fechaNacimiento;
	private int edad;
	private String genero;
	private Float estaturaEnMetros;
	private Float pesoEnKilogramos;
	private Integer cantidadVisitas;
	private String planeta;

	public Persona(int numeroIdentificacion, String nombre, Date fechaNacimiento, String genero, Float estaturaEnMetros,
			Float pesoEnKilogramos, Integer cantidadVisitas, String planeta) {

		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.estaturaEnMetros = estaturaEnMetros;
		this.pesoEnKilogramos = pesoEnKilogramos;
		this.cantidadVisitas = cantidadVisitas;
		this.planeta = planeta;
	}

	public void calcularEdad() {
		LocalDate hoy = LocalDate.now();
		Date ahora = new Date();
		ahora.setTime(fechaNacimiento.getTime());
		LocalDate nacimiento = ahora.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period diferenciaEntreFechas = Period.between(nacimiento, hoy);
		edad = diferenciaEntreFechas.getYears();
	}

	public void sumarVisitas() {
		if (cantidadVisitas == null) {
			cantidadVisitas = 1;
		} else {
			cantidadVisitas++;
		}
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

	public Float getEstaturaEnMetros() {
		return estaturaEnMetros;
	}

	public Float getPesoEnKilogramos() {
		return pesoEnKilogramos;
	}

	public Integer getCantidadVisitas() {
		return cantidadVisitas;
	}

	public String getPlaneta() {
		return planeta;
	}
}
