package com.trycore.planetario.comun.infraestructura.excepciones;

public class Excepcion {
	private String nombre;
	private String mensaje;

	public Excepcion(String nombre, String mensaje) {
		this.nombre = nombre;
		this.mensaje = mensaje;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMensaje() {
		return mensaje;
	}
}
