package br.com.pan.address.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.pan.address.dto.response.CustomerResponseDTO;
import br.com.pan.address.services.CustomerService;

@RunWith(SpringRunner.class)
@EnableSpringDataWebSupport
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerServiceMock;

	@Test
	public void getCustomerTest() throws Exception {
		final String URI = "/v1/customer/01234567890";
		when(customerServiceMock.getCustomerByCpf(Mockito.anyString())).thenReturn(new CustomerResponseDTO());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void saveCustomerTest() throws Exception {
		final String URI = "/v1/customer";
		doNothing().when(customerServiceMock).saveCustomer(Mockito.any());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).content(createPayload("json/customerPayload.json")).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	@Test
	public void updateAddressTest() throws Exception {
		final String URI = "/v1/customer/address";
		doNothing().when(customerServiceMock).updateAddress(Mockito.any());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URI).content(createPayload("json/customerPayload.json")).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}
	
	private String createPayload(String path) throws IOException {
		File file = new ClassPathResource(path).getFile();
		return new String(Files.readAllBytes(Paths.get(file.getPath())));
	}
}
