package com.food.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.RestaurentMenuDTO;
import com.food.dto.RestrauentVO;
import com.food.dto.UserTimeDTO;
import com.food.repository.RestrauentRepository;
import com.food.service.RestrauentService;
import com.food.util.UserSatisfactionComparator;

/**
 * @author venkatasureshbabu
 * 
 * Service class to calculate customer satisfaction based on total available time
 *
 */
@Service
public class RestrauentServiceImpl implements RestrauentService {

	private static Logger LOGGER=LoggerFactory.getLogger(RestrauentServiceImpl.class);
	@Autowired
	private RestrauentRepository repository;

	/**
	 * @return Integer
	 * 
	 * method used to calculate maxSatisfaction of customer based on TotalTime Available and
	 *  items choose from menu
	 */
	@Override
	public Integer getMaxSatisfaction()  {
		LOGGER.info("Inside method getMaxSatisfaction()");
		UserTimeDTO menuItems = repository.getMenuItems();
		int minutes = menuItems.getMinutes();

		List<RestaurentMenuDTO> restMenuList = menuItems.getRestMenuList();
		List<RestrauentVO> newList = new ArrayList<>();
		for (RestaurentMenuDTO dto : restMenuList) {
			RestrauentVO vo = new RestrauentVO();
			vo.setTime(dto.getTimetaken());
			vo.setSatisfaction(dto.getSatisfactionAmt() / dto.getTimetaken());
			newList.add(vo);
		}
		Collections.sort(newList, new UserSatisfactionComparator());

		int totalSatisfaction = 0;
		int totalValueTime = 0;
		for (RestrauentVO vo : newList) {
			totalSatisfaction = totalSatisfaction + vo.getSatisfaction();
			totalValueTime = totalValueTime + vo.getTime();
			if (totalValueTime > minutes) {
				break;
			}
			LOGGER.debug("total Satisfaction of customer",totalSatisfaction);
		}

		return totalSatisfaction;
	}

}
