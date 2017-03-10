package com.food.repository.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.food.dto.RestaurantMenuDTO;
import com.food.dto.UserTimeDTO;
import com.food.repository.RestaurantRepository;
import com.food.util.RestaurantConstants;

/**
 * @author venkatasureshbabu
 * 
 * Repository to get All Menu Items
 *
 */
@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository{
	
	private static Logger LOGGER=LoggerFactory.getLogger(RestaurantRepositoryImpl.class);
	
	/**
	 * @return UserTimeDTO
	 * 
	 * method to get all menuItems form fileSystem/Data base
	 */
    @Override
    public UserTimeDTO getMenuItems() {
        LOGGER.info("inside method getMenuItems()");
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(RestaurantConstants.FILE_PATH);
        final UserTimeDTO userTimeDTO = new UserTimeDTO();
        final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
        String rowData = RestaurantConstants.NULL;
        int item = RestaurantConstants.ZERO;
        try {
        	//reading file and setting to dto.
            while ( (rowData = bufferReader.readLine()) != null ) {
                final String[] rowValues = rowData.split(RestaurantConstants.SPACE);
                if ( item == RestaurantConstants.ZERO ) {
                    userTimeDTO.setMinutes(Integer.parseInt(rowValues[RestaurantConstants.ZERO]));
                    userTimeDTO.setTotalItems(Integer.parseInt(rowValues[RestaurantConstants.ONE]));
                    item++;
                    continue;
                }
                final RestaurantMenuDTO restMenuDTO = new RestaurantMenuDTO();
                restMenuDTO.setItemNo(item);
                restMenuDTO.setSatisfactionAmt(Integer.parseInt(rowValues[RestaurantConstants.ZERO]));
                restMenuDTO.setTimeTaken(Integer.parseInt(rowValues[RestaurantConstants.ONE]));
                userTimeDTO.getRestMenuList().add(restMenuDTO);
                item++;
            }
        } catch ( NumberFormatException | IOException exception ) {
            LOGGER.error("Exception occured while reading file", exception);
        }
        return userTimeDTO;
    }

}
