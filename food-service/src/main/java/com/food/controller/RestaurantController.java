package com.food.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.ServiceResponse;
import com.food.service.RestaurantService;


/**
 * @author venkatasureshbabu
 * 
 * Http end point Controller to handle  RestrauenMenu Items and deligating each request to Service
 *
 */
@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService service;
	
	
	/**
	 * @return Integer
	 * 
	 * http end point to get maxSatiafaction of customer
	 * 
	 */
	@RequestMapping("/getSatisfaction")
	public ServiceResponse getMaxSatisfaction() 
	{
		return service.getMaxSatisfaction();
	}
	
	

}
