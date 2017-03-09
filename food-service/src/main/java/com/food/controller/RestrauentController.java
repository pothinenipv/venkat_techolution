package com.food.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.service.RestrauentService;


/**
 * @author venkatasureshbabu
 * 
 * Http end point Controller to handle  RestrauenMenu Items and deligating each request to Service
 *
 */
@RestController
public class RestrauentController {
	
	@Autowired
	private RestrauentService service;
	
	
	/**
	 * @return Integer
	 * 
	 * http end point to get maxSatiafaction of customer
	 * 
	 */
	@RequestMapping("/getSatisfaction")
	public Integer getMaxSatisfaction() 
	{
		return service.getMaxSatisfaction();
	}
	
	

}
