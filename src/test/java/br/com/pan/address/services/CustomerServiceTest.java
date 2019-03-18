package br.com.pan.address.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import br.com.pan.address.dto.response.CustomerResponseDTO;
import br.com.pan.address.entities.CustomerEntity;
import br.com.pan.address.exception.CustomerNotFoundException;
import br.com.pan.address.repositories.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	
	public static ObjectMapper objectMapper = new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module())
			.registerModule(new JavaTimeModule());

	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepository customerRepositoryMock;
	
	@Test
	public void getCustomerByCpfSuccessTest() throws IOException {
		CustomerEntity customerEntity = createPayload("json/customerPayload.json");
		when(customerRepositoryMock.findByCpf(Mockito.anyString())).thenReturn(customerEntity);
		CustomerResponseDTO customerByCpf = customerService.getCustomerByCpf("04283273465");
		assertEquals(customerByCpf.getCpf(), customerEntity.getCpf());
	}
	
	@Test(expected=CustomerNotFoundException.class)
	public void getCustomerByCpfFailedTest() throws IOException {
		when(customerRepositoryMock.findByCpf(Mockito.anyString())).thenReturn(null);
		customerService.getCustomerByCpf("123456789");
	}
	
	private CustomerEntity createPayload(String path) throws IOException {
		File file = new ClassPathResource(path).getFile();
		return objectMapper.readValue(file, CustomerEntity.class);
	}
}
