package com.food.test.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.food.repository.impl.RestrauentRepositoryImpl;

public class RestrauentRepositoryTest {

	@InjectMocks
	private RestrauentRepositoryImpl restrauentRepositoryImpl;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetMenuItems() {
		restrauentRepositoryImpl.getMenuItems();

	}

}
