package com.boot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.service.BootService;


@RestController
public class BootExample {
	
	@Autowired
	private BootService service;
	
	@RequestMapping("/")
	public String get()
	{
		return service.getString();
	}
	
	/*public static void main(String [] a)
	{
		SpringApplication.run(BootExample.class, a);
	}*/

}
