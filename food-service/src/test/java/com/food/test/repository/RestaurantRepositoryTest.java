package com.food.test.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.food.repository.impl.RestaurantRepositoryImpl;

public class RestaurantRepositoryTest {

	@InjectMocks
	private RestaurantRepositoryImpl restrauentRepositoryImpl;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetMenuItems() {
		restrauentRepositoryImpl.getMenuItems();

	}

}
