package com.trycore.planetario.comun.aplicacion.manejadores;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoRespuesta<C, R> {

	@Transactional
	R ejecutar(C comando);
}
