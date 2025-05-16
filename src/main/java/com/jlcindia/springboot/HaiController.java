package com.jlcindia.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaiController {

	@GetMapping(value="/myhai/{name}") 
	public Hai getMessage(@PathVariable String name) { 
	System.out.println("HaiController - getMessage()"); 
	Hai hai =new Hai(901,name, "Hai Guys !!!" ); 
	return hai; 
	} 
	
}
