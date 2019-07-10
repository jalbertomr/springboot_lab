package com.bext.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="asignaciones")
public class MiinfoRestController {
	private String asignadaExternamente;
	
	@RequestMapping(method=RequestMethod.GET, value="/miinfo", produces="text/plain")
	public String miinfo() throws UnknownHostException {
		String hostname = null;
		try {
			hostname = InetAddress.getLocalHost().getHostAddress();	
		} catch (UnknownHostException e) {
			hostname = "desconocido ," + e.getMessage();
		}
		
		return "Información de microserver springboot_lab, hostname: " + hostname +"\n" +
		"propiedad de clase 'asignadaExternamente' en application.properties tiene el valor: " + 
		asignadaExternamente +"\n";
	}

	
	public String getAsignadaExternamente() {
		return asignadaExternamente;
	}

	public void setAsignadaExternamente(String asignadaExternamente) {
		this.asignadaExternamente = asignadaExternamente;
	}
}
