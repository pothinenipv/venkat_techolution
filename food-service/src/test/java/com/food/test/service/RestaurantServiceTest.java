package com.food.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.food.dto.RestaurantMenuDTO;
import com.food.dto.ServiceResponse;
import com.food.dto.UserTimeDTO;
import com.food.repository.impl.RestaurantRepositoryImpl;
import com.food.service.RestaurantService;
import com.food.service.impl.RestaurantServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={RestaurantServiceImpl.class,RestaurantRepositoryImpl.class})
public class RestaurantServiceTest {

	@InjectMocks
	private RestaurantServiceImpl restrauentServiceImplMock;

	@Mock
	private RestaurantRepositoryImpl repositoryImplMock;

	@Autowired
	private RestaurantService restrauentService;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetMaxSatisfactionMock() {
		RestaurantMenuDTO dto = new RestaurantMenuDTO();
		dto.setItemNo(1);
		dto.setSatisfactionAmt(1000);
		dto.setTimeTaken(250);

		RestaurantMenuDTO dto1 = new RestaurantMenuDTO();
		dto1.setItemNo(2);
		dto1.setSatisfactionAmt(10000);
		dto1.setTimeTaken(200);
		List<RestaurantMenuDTO> dtoList = new ArrayList<>();
		dtoList.add(dto1);
		UserTimeDTO userTimeDTO = new UserTimeDTO();
		userTimeDTO.setTotalItems(2);
		userTimeDTO.setMinutes(500);
		userTimeDTO.setRestMenuList(dtoList);
		Mockito.when(repositoryImplMock.getMenuItems()).thenReturn(userTimeDTO);
		ServiceResponse serviceResponse = restrauentServiceImplMock
				.getMaxSatisfaction();
		Assert.notNull(serviceResponse);

	}

	@Test
	public void testGetMaxSatisfaction() {
		restrauentService.getMaxSatisfaction();
	}
}
