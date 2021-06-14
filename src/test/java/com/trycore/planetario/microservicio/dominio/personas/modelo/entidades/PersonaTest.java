package com.trycore.planetario.microservicio.dominio.personas.modelo.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class PersonaTest {

	@Test
	public void laEdadDebeSerCeroTest() {
		Persona persona = new PersonaTestDataBuilder().construir();

		persona.calcularEdad();

		assertEquals(0, persona.getEdad());
	}

	@Test
	public void laEdadDebeSerUnoTest() {
		Date hoy = new Date();
		long milisegundosAnioAnterior = hoy.getTime() - 31556900000L;
		Date fechaNacimiento = new Date(milisegundosAnioAnterior);
		Persona persona = new PersonaTestDataBuilder().conFechaNacimiento(fechaNacimiento).construir();

		persona.calcularEdad();

		assertEquals(1, persona.getEdad());
	}

	@Test
	public void laCantidadDeVisitasDeberSerOnce() {
		Persona persona = new PersonaTestDataBuilder().construir();

		persona.sumarVisitas();

		assertEquals(11, persona.getCantidadVisitas());
	}

	@Test
	public void laCantidadDeVisitasDeberSerUno() {
		Persona persona = new PersonaTestDataBuilder().conCantidadVisitas(null).construir();

		persona.sumarVisitas();

		assertEquals(1, persona.getCantidadVisitas());
	}
}
