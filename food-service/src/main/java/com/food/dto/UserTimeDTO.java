package com.food.dto;

import java.util.ArrayList;
import java.util.List;

import com.food.dto.RestaurentMenuDTO;

public class UserTimeDTO {

	private int minutes;
	private int totalItems;
	private List<RestaurentMenuDTO> restMenuList;

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

	public List<RestaurentMenuDTO> getRestMenuList() {
		if (restMenuList==null) {
			restMenuList= new ArrayList<>();
		}
		return restMenuList;
	}

	public void setRestMenuList(List<RestaurentMenuDTO> restMenuList) {
		this.restMenuList = restMenuList;
	}

}
