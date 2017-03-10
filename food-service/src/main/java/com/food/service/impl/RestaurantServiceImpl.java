package com.food.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.RestaurantMenuDTO;
import com.food.dto.RestaurantVO;
import com.food.dto.ServiceResponse;
import com.food.dto.UserTimeDTO;
import com.food.repository.RestaurantRepository;
import com.food.service.RestaurantService;
import com.food.util.RestaurantConstants;
import com.food.util.UserSatisfactionComparator;

/**
 * @author venkatasureshbabu
 * 
 *         Service class to calculate customer satisfaction based on total
 *         available time
 * 
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	private static Logger LOGGER = LoggerFactory
			.getLogger(RestaurantServiceImpl.class);
	@Autowired
	private RestaurantRepository restaurantRepository;

	/**
	 * @return ServiceResponse
	 * 
	 *         method used to calculate maxSatisfaction of customer based on
	 *         TotalTime Available and items choose from menu
	 */
	@Override
	public ServiceResponse getMaxSatisfaction() {
		LOGGER.info("Inside method getMaxSatisfaction()");
		UserTimeDTO menuItems = restaurantRepository.getMenuItems();
		int minutes = menuItems.getMinutes();

		List<RestaurantMenuDTO> restMenuDTOs = menuItems.getRestMenuList();
		List<RestaurantVO> restaurantVOs = new ArrayList<>();
		for (RestaurantMenuDTO restMenuDTO : restMenuDTOs) {
			RestaurantVO restaurantVO = new RestaurantVO();
			restaurantVO.setTime(restMenuDTO.getTimeTaken());
			restaurantVO.setSatisfaction(restMenuDTO.getSatisfactionAmt());
			//caluclating satisfactionRatio.
			restaurantVO.setSatisfactionRatio(restMenuDTO.getSatisfactionAmt()
					/ restMenuDTO.getTimeTaken());
			restaurantVOs.add(restaurantVO);
		}
		//sorting based on satisfactionRatio.
		Collections.sort(restaurantVOs, new UserSatisfactionComparator());
		ServiceResponse response = new ServiceResponse();
		response.setMaxSatisfaction(calculateTotalSatisfaction(minutes,
				restaurantVOs));

		return response;
	}

	private int calculateTotalSatisfaction(int minutes,
			List<RestaurantVO> restaurantVOs) {
		int totalSatisfaction = RestaurantConstants.ZERO;
		int totalValueTime = RestaurantConstants.ZERO;
		for (RestaurantVO restaurantVO : restaurantVOs) {
			totalValueTime = totalValueTime + restaurantVO.getTime();
			//ignore if totalTime is greaterThan avaliableTime.
			if (totalValueTime > minutes) {
				break;
			} else {
				totalSatisfaction = totalSatisfaction
						+ restaurantVO.getSatisfaction();
			}
		}
		return totalSatisfaction;
	}

}
