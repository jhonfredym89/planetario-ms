package com.trycore.planetario.microservicio.aplicacion.personas.consulta;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ManejadorConsultaPersona {

	public void ejecutar() {

	}
}
