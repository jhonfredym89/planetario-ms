package com.trycore.planetario.comun.infraestructura.excepciones;

public class ExcepcionSinDatos extends RuntimeException {

	private static final long serialVersionUID = -5604382819607855481L;

	public ExcepcionSinDatos(String mensaje) {
		super(mensaje);
	}
}
