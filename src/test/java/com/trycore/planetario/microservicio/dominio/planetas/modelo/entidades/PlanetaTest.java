package com.trycore.planetario.microservicio.dominio.planetas.modelo.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlanetaTest {

	@Test
	public void laCantidadDeVisitasDeberSerOnce() {
		Planeta planeta = new PlanetaTestDataBuilder().construir();

		planeta.sumarVisitas();

		assertEquals(11, planeta.getCantidadVisitas());
	}

	@Test
	public void laCantidadDeVisitasDeberSerUno() {
		Planeta planeta = new PlanetaTestDataBuilder().conCantidadVisitas(null).construir();

		planeta.sumarVisitas();

		assertEquals(1, planeta.getCantidadVisitas());
	}
}
