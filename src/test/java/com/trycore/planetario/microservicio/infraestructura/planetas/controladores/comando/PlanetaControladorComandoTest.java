package com.trycore.planetario.microservicio.infraestructura.planetas.controladores.comando;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.trycore.planetario.comun.infraestructura.excepciones.ExcepcionManejador;

@SpringBootTest
public class PlanetaControladorComandoTest {
	
	@Autowired
	private PlanetaControladorComando planetaControladorComando;

	@Autowired
	private ExcepcionManejador excepcionManejador;

	@Test
	public void incrementarVisitas() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(planetaControladorComando).build();

		mockMvc.perform(put("/planetario/v1/planetas/Tierra/visitas").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void incrementarVisitasPersonaNoExistente() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(planetaControladorComando, excepcionManejador).build();

		mockMvc.perform(put("/planetario/v1/planetas/Neptuno/visitas").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}
