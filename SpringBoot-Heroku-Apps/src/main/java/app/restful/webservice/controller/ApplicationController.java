package app.restful.webservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.restful.webservice.model.EmpPhoneNum;
import app.restful.webservice.model.Employee;

@RestController
@RequestMapping("/app")
public class ApplicationController {

	@GetMapping("/name")
	public String appName() {
		return "SpringBootHerokuApps says Hello from Ashish!!";
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

		Employee e = new Employee(1, "Ashish", "Module Lead", "Centurylink", ll);
		return e;
	}

	@GetMapping("/demo/plaintext")
	@ResponseBody
	public String methodname(HttpServletResponse response) {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		return "Sending Plain text Response";

	}

	private Map<Integer, String> tinyURLMap = new HashMap<>();
	private String fileAppender ="shortner_";

	@GetMapping("/tinyUrlGenerator/{origUrl}/**")
	public synchronized String genereateAndUpdateTinyUrl(@PathVariable String origUrl) {
		int key = 0;
		if(origUrl!=null) {
			 key = getRandomNumber();
			if(tinyURLMap.get(key)==null) {
				tinyURLMap.put(key, origUrl);
			}
		}
		return fileAppender+key;
	}
	@GetMapping("/getOrignalUrl/{tinyUrl}/**")
	public String getOriginalUrl(@PathVariable String tinyUrl) {
		String [] arr = tinyUrl.split("_");
		
		if(String.valueOf(arr[1]).length()!=7 ) {
			return "Invalid number";
		}else {
			for(Map.Entry<Integer, String> entry : tinyURLMap.entrySet()) {
				if(tinyURLMap.containsKey(Integer.parseInt(arr[1]))) {
					return entry.getValue();
				}else {
					return "URL not found";
				}
			}
		}
		return "URL not found";
	}

	public static synchronized int getRandomNumber() {
		int randomNum = (int) ((Math.random() * 9000000) + 1000000);
		return randomNum;
	}

}
