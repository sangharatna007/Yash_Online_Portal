package com.yash.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yash.controller.SellerController;
import com.yash.dao.SellerDao;
import com.yash.model.Product;
import com.yash.service.SellerService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SellerControllerTest {
	
	@InjectMocks
	private SellerController sellerController;
	
	@Mock
	private SellerService sellerService;
	
	@Mock
	private SellerDao sellerDao;
	
	private MockMvc mockMvc;

   

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(sellerController)
				.build();
	}

	@Test
	public void getAllProductTest() throws Exception{
		List<Product> products = Arrays.asList(
				new Product(6, "Mobile", 2, 10000.0, 1, 1, 1)
			);
		
		when(sellerService.getAllProducts()).thenReturn(products);
		
		mockMvc.perform(get("/seller/product"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].product_id", is(6)))
		.andExpect(jsonPath("$[0].product_name", is("Mobile")));
		
		verify(sellerService, times(1)).getAllProducts();
		verifyNoMoreInteractions(sellerService);
	}
	
	@Test
    public void getProduct() throws Exception {
        when(sellerService.getProduct(21)).thenReturn(new Product());
 
        mockMvc.perform(get("/seller/product/{id}", 21))
                .andExpect(status().isOk());
 
        verify(sellerService, times(1)).getProduct(21);
        verifyNoMoreInteractions(sellerService);
    }
	
	
}
