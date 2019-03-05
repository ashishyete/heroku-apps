package app.restful.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ApplicationController {

	@GetMapping("/name")
	public String appName() {
		return "SpringBootHerokuApps";
	}

	@GetMapping("/user/{userName}")
	public String welcomeUser(@PathVariable("userName") String user) {
		return "Welcome : " + user;
	}
	
	

}
