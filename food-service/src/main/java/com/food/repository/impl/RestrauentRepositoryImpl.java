package com.food.repository.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.food.dto.RestaurentMenuDTO;
import com.food.dto.UserTimeDTO;
import com.food.repository.RestrauentRepository;

/**
 * @author venkatasureshbabu
 * 
 * Repository to get All Menu Items
 *
 */
@Repository
public class RestrauentRepositoryImpl implements RestrauentRepository{
	
	private static Logger LOGGER=LoggerFactory.getLogger(RestrauentRepositoryImpl.class);
	
	/**
	 * @return UserTimeDTO
	 * 
	 * method to get all menuItems form fileSystem/Data base
	 */
	@Override
	public UserTimeDTO getMenuItems() {
		LOGGER.info("inside method getMenuItems()");
		InputStream resourceAsStream = getClass().getClassLoader()
				.getResourceAsStream("data.txt");
		UserTimeDTO userTimeDTO = new UserTimeDTO();
		BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
		String line = null;
		int item = 0;
		try {
			while ((line = br.readLine()) != null) {
				String[] split = line.split(" ");
				if (item == 0) {					
					userTimeDTO.setMinutes(Integer.parseInt(split[0]));
					userTimeDTO.setTotalItems(Integer.parseInt(split[1]));
					item++;
					continue;
				}
				RestaurentMenuDTO restaurentMenuDTO = new RestaurentMenuDTO();
				restaurentMenuDTO.setItemNo(item);
				restaurentMenuDTO.setSatisfactionAmt(Integer.parseInt(split[0]));
				restaurentMenuDTO.setTimetaken(Integer.parseInt(split[1]));
				userTimeDTO.getRestMenuList().add(restaurentMenuDTO);

				item++;
			}
		} catch (NumberFormatException | IOException exception) {
			LOGGER.error("Exception occured while reading file",exception);
		}
return userTimeDTO;
	}

}
