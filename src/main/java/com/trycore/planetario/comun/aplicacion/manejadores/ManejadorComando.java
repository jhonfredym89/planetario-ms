package com.trycore.planetario.comun.aplicacion.manejadores;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<C> {

	@Transactional
	void ejecutar(C comando);
}
