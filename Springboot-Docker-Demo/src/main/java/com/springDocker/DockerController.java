package com.springDocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DockerController {

	@GetMapping("/docker")
	public String testContainer() {
		return "<b> ---------------------------------------------------------------------------------"
				+ "/*******   THIS IS FOR DOCKER IMAGE TESTING FROM SPRING BOOT APPLICATION   ******/"
				+ "----------------------------------------------------------------------------------</b>";
	}

}
