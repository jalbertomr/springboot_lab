package com.bext.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@RequestMapping(method=RequestMethod.GET, value="/info", produces="text/plain")
	public String info() throws UnknownHostException {
		String hostname = null;
		try {
			hostname = InetAddress.getLocalHost().getHostAddress();	
		} catch (UnknownHostException e) {
			hostname = "desconocido ," + e.getMessage();
		}
		
		return "Información de microserver springboot_lab, hostname: " + hostname;
	}
}
