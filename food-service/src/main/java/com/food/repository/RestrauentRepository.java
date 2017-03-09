package com.food.repository;

import com.food.dto.UserTimeDTO;

public interface RestrauentRepository {
	
	/**
	 * @return UserTimeDTO
	 * 
	 * method to get all menuItems form fileSystem/Data base
	 */
	public UserTimeDTO getMenuItems();
	
	 

}
