package com.food.service;

import com.food.dto.ServiceResponse;


public interface RestaurantService {
	
	 /**
	 * @return ServiceResponse
	 * 
	 * method used to caluclate maxSatisfaction of customer based on TotalTime Available and
	 *  items choosen from menu
	 */
	ServiceResponse getMaxSatisfaction();

}
