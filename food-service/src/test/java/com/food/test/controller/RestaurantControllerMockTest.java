package com.food.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.food.controller.RestaurantController;
import com.food.dto.ServiceResponse;
import com.food.service.impl.RestaurantServiceImpl;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
public class RestaurantControllerMockTest {

	@InjectMocks
	RestaurantController controller;

	private MockMvc mockMvc;

	@Mock
	private RestaurantServiceImpl serviceImplMock;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}

	@Test
	public void testGetSatisfactionMock() throws Exception {
		Mockito.when(serviceImplMock.getMaxSatisfaction()).thenReturn(new ServiceResponse());
		mockMvc.perform(MockMvcRequestBuilders.get("/getSatisfaction"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
