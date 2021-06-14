package com.trycore.planetario.comun.infraestructura.excepciones;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExcepcionManejador extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcepcionManejador.class);
	private static final String OCURRIO_UN_ERROR_CONTACTAR_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador";
	private static final Map<String, Integer> CODIGOS_ESTADO_HTTP = new ConcurrentHashMap<String, Integer>();

	public ExcepcionManejador() {
		CODIGOS_ESTADO_HTTP.put(ExcepcionSinDatos.class.getSimpleName(), HttpStatus.NO_CONTENT.value());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Excepcion> manejarExcepciones(Exception excepcion) {
		String nombre = excepcion.getClass().getSimpleName();
		String mensaje = excepcion.getMessage();
		Integer codigo = CODIGOS_ESTADO_HTTP.get(nombre);
		ResponseEntity<Excepcion> resultado;
		HttpStatus estadoHttp;

		if (codigo == null) {
			LOGGER.error(nombre, excepcion);
			nombre = OCURRIO_UN_ERROR_CONTACTAR_ADMINISTRADOR;
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		} else {
			estadoHttp = HttpStatus.valueOf(codigo);
		}

		Excepcion excepcionRespuesta = new Excepcion(nombre, mensaje);
		resultado = new ResponseEntity<>(excepcionRespuesta, estadoHttp);

		return resultado;
	}
}
