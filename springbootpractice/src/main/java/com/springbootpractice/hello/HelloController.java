package com.springbootpractice.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome";
	}
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi Ashish";
	}
}
