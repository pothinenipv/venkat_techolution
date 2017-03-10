package com.food.dto;

import java.util.ArrayList;
import java.util.List;

public class UserTimeDTO {

	private int minutes;
	private int totalItems;
	private List<RestaurantMenuDTO> restMenuList;
	
	public UserTimeDTO(){
	    super();
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public List<RestaurantMenuDTO> getRestMenuList() {
		if (restMenuList==null) {
			restMenuList= new ArrayList<>();
		}
		return restMenuList;
	}

	public void setRestMenuList(List<RestaurantMenuDTO> restMenuList) {
		this.restMenuList = restMenuList;
	}

}
