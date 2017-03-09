package com.boot.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
public class BootExample {
	
	
	@RequestMapping("/")
	public String get()
	{
		return "hello world";
	}
	
	public static void main(String [] a)
	{
		SpringApplication.run(BootExample.class, a);
	}

}
