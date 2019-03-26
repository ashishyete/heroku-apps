package app.restful.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.restful.webservice.model.EmpPhoneNum;
import app.restful.webservice.model.Employee;

@RestController
@RequestMapping("/app")
public class ApplicationController {

	@GetMapping("/name")
	public String appName() {
		return "SpringBootHerokuApps says Hello!!";
	}

	@GetMapping("/user/{userName}")
	public String welcomeUser(@PathVariable("userName") String user) {
		return "Welcome : " + user;
	}
	
	@GetMapping("/getEmp")
	public Employee getEmp() {
		return empLoad();
	}
	
	@PostMapping("/Emp")
	public Employee getEmployee(@RequestBody Employee e) {
		System.out.println("Employee Recieved");
		return empLoad();
	}

	
	private Employee empLoad() {
		EmpPhoneNum ph1 = new EmpPhoneNum();
		ph1.setEmpPhone("1234");
		
		EmpPhoneNum ph2 = new EmpPhoneNum();
		ph2.setEmpPhone("2345");
		
		List<EmpPhoneNum> ll = new ArrayList<>();
		ll.add(ph1);
		ll.add(ph2);
		
		Employee e = new Employee(1, "Ashish", "Module Lead", "Centurylink",ll);
		return e;
	}
	
}
