package com.bext.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="mensajeando")
public class MensajeRestController {
	private String asignadaExternamente;
	private String backendServiceHost;
	private int backendServicePort;
	
	@RequestMapping(value = "/mensajeando", method = RequestMethod.GET, produces = "text/plain")
	public String mensajeando() {
		String backendServiceUrl = 
			String.format("http://%s:%d/api/backend?mensaje={mensaje} ,%s", 
			backendServiceHost, backendServicePort, asignadaExternamente);
		    System.out.println("Enviando a : " + backendServiceUrl);
		return backendServiceUrl;
	}

	public String getBackendServiceHost() {
		return backendServiceHost;
	}

	public void setBackendServiceHost(String backendServiceHost) {
		this.backendServiceHost = backendServiceHost;
	}

	public int getBackendServicePort() {
		return backendServicePort;
	}

	public void setBackendServicePort(int backendServicePort) {
		this.backendServicePort = backendServicePort;
	}

	public String getAsignadaExternamente() {
		return asignadaExternamente;
	}

	public void setAsignadaExternamente(String asignadaExternamente) {
		this.asignadaExternamente = asignadaExternamente;
	}
}
