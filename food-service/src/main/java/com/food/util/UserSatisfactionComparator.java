package com.food.util;

import java.util.Comparator;

import com.food.dto.RestaurantVO;

public class UserSatisfactionComparator implements Comparator<RestaurantVO>{

	@Override
	public int compare(RestaurantVO restaurantVO1, RestaurantVO restaurantVO2) {
		return restaurantVO2.getSatisfactionRatio().compareTo(restaurantVO1.getSatisfactionRatio());
	}

}
