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

import com.food.dto.RestaurentMenuDTO;
import com.food.dto.UserTimeDTO;
import com.food.repository.impl.RestrauentRepositoryImpl;
import com.food.service.RestrauentService;
import com.food.service.impl.RestrauentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={RestrauentServiceImpl.class,RestrauentRepositoryImpl.class})
public class RestrauentServiceTest {

	@InjectMocks
	private RestrauentServiceImpl restrauentServiceImplMock;

	@Mock
	private RestrauentRepositoryImpl repositoryImplMock;

	@Autowired
	private RestrauentService restrauentService;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetMaxSatisfactionMock() {
		RestaurentMenuDTO dto = new RestaurentMenuDTO();
		dto.setItemNo(1);
		dto.setSatisfactionAmt(1000);
		dto.setTimetaken(250);

		RestaurentMenuDTO dto1 = new RestaurentMenuDTO();
		dto1.setItemNo(2);
		dto1.setSatisfactionAmt(10000);
		dto1.setTimetaken(200);
		List<RestaurentMenuDTO> dtoList = new ArrayList<>();
		dtoList.add(dto1);
		UserTimeDTO userTimeDTO = new UserTimeDTO();
		userTimeDTO.setTotalItems(2);
		userTimeDTO.setMinutes(500);
		userTimeDTO.setRestMenuList(dtoList);
		Mockito.when(repositoryImplMock.getMenuItems()).thenReturn(userTimeDTO);
		Integer maxSatisfaction = restrauentServiceImplMock
				.getMaxSatisfaction();
		Assert.notNull(maxSatisfaction);

	}

	@Test
	public void testGetMaxSatisfaction() {
		restrauentService.getMaxSatisfaction();
	}
}
