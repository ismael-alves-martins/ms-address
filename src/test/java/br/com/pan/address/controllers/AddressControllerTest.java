package br.com.pan.address.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.pan.address.dto.response.CepResponseDTO;
import br.com.pan.address.dto.response.CityResponseDTO;
import br.com.pan.address.dto.response.StateResponseDTO;
import br.com.pan.address.services.AddressService;

@RunWith(SpringRunner.class)
@EnableSpringDataWebSupport
@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AddressService addressServiceMock;
	
	@Test
	public void getAddressByCepTest() throws Exception {
		final String URI = "/v1/cep/012345678";
		when(addressServiceMock.searchAddressByCep(Mockito.anyString())).thenReturn(new CepResponseDTO());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void getStatesListTest() throws Exception {
		final String URI = "/v1/states";
		when(addressServiceMock.getStateList()).thenReturn(new ArrayList<StateResponseDTO>());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void getCityByStateTest() throws Exception {
		final String URI = "/v1/states/1/city";
		when(addressServiceMock.getCityByState(Mockito.anyString())).thenReturn(new ArrayList<CityResponseDTO>());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
