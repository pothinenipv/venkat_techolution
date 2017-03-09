package com.food.util;

import java.util.Comparator;

import com.food.dto.RestrauentVO;

public class UserSatisfactionComparator implements Comparator<RestrauentVO>{

	@Override
	public int compare(RestrauentVO o1, RestrauentVO o2) {
		return o2.getSatisfaction().compareTo(o1.getSatisfaction());
	}

}
