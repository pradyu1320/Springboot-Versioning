package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	//URI Versioning
	/*in postman test the url like
	*http://localhost:8080/v1/student
	*http://localhost:8080/v2/student
	*/
	@GetMapping("v1/student")
	public StudentV1 studentV1() {
		return new StudentV1("Bob Charli");
	}
	@GetMapping("v2/student")
	public StudentV2 studentV2() {
		return new StudentV2(new Name("Bob","Charli"));
	}
	//Request parameter versioning
	/* In postman test the url like
	 * http://localhost:8080/student/param?version=1
	 * http://localhost:8080/student/param?version=2
	*/	 
	@GetMapping(value="/student/param",params="version=1")
	public StudentV1 paramV1() {
		return new StudentV1("John Sena");
	}
	@GetMapping(value="/student/param",params="version=2")
	public StudentV2 paramV2() {
		return new StudentV2(new Name("Jhon","sena"));
	}
	//Header versioning
	/*In postman select the header option and give the name as X-API-VERSION and value as 1/2 ten try
	 * http://localhost:8080/student/header for both change the value 	 * 
	 */
	@GetMapping(value="/student/header",headers="X-API-VERSION=1")
	public StudentV1 headerV1() {
		return new StudentV1("Robert Vince");
	}
	@GetMapping(value="/student/header",headers="X-API-VERSION=2")
	public StudentV2 headerV2() {
		return new StudentV2(new Name("Robert","Vince"));
	}
	//Media Type versionoing
	/*in postman select the header option and give the name as Accept and value as application/vnd.company.app-v1+json/application/vnd.company.app-v2+json 
	 * then try this url for both request
	 * http://localhost:8080/student/produces
	 */
	@GetMapping(value="/student/produces",produces="application/vnd.company.app-v1+json")
	public StudentV1 producesV1() {
		return new StudentV1("Bob Lee");
	}
	@GetMapping(value="/student/produces",produces="application/vnd.company.app-v2+json")
	public StudentV2 producesV2(){
		return new StudentV2(new Name("Bob","Lee"));
	}
}
