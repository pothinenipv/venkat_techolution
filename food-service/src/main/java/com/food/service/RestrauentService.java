package com.food.service;


public interface RestrauentService {
	
	 /**
	 * @return Integer
	 * 
	 * method used to caluclate maxSatisfaction of customer based on TotalTime Available and
	 *  items choosen from menu
	 */
	Integer getMaxSatisfaction();

}
