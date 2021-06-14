package com.trycore.planetario.microservicio.infraestructura.controladores.comando;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.trycore.planetario.comun.infraestructura.excepciones.ExcepcionManejador;
import com.trycore.planetario.microservicio.infraestructura.personas.controladores.comando.PersonaControladorComando;

@SpringBootTest
public class PersonaControladorComandoTest {

	@Autowired
	private PersonaControladorComando personaControladorComando;

	@Autowired
	private ExcepcionManejador excepcionManejador;

	@Test
	public void incrementarVisitas() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personaControladorComando).build();

		mockMvc.perform(put("/planetario/v1/personas/123456/visitas").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void incrementarVisitasPersonaNoExistente() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personaControladorComando, excepcionManejador).build();

		mockMvc.perform(put("/planetario/v1/personas/1/visitas").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}
