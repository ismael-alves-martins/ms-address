package br.com.pan.address.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.address.constants.ErrorCodes;
import br.com.pan.address.dto.request.ClientRequestDTO;
import br.com.pan.address.dto.response.AddressDTO;
import br.com.pan.address.dto.response.CustomerResponseDTO;
import br.com.pan.address.entities.AddressEntity;
import br.com.pan.address.entities.CustomerEntity;
import br.com.pan.address.exception.CustomerNotFoundException;
import br.com.pan.address.repositories.AddressRepository;
import br.com.pan.address.repositories.CustomerRepository;
import br.com.pan.address.util.Util;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerResponseDTO getCustomerByCpf(String cpf) {
		CustomerEntity customerEntity = customerRepository.findByCpf(cpf);
		if (customerEntity == null) {
			throw new CustomerNotFoundException(ErrorCodes.CUSTOMER_NOT_FOUND.getCode(),
					String.format("Customer with CPF %s not found.", cpf));
		}
		return modelMapper.map(customerEntity, CustomerResponseDTO.class);
	}

	@Override
	public List<CustomerResponseDTO> getAllClients() {
		logger.info("start getAllClients - INFO");
		logger.debug("start getAllClients - DEBUG");
		logger.warn("start getAllClients - WARN");
		logger.error("start getAllClients - ERROR");
		List<CustomerEntity> CustomerEntity = customerRepository.findAll();
		return Util.mapAllObjects(CustomerEntity, CustomerResponseDTO.class, modelMapper);
	}

	@Override
	public void saveCustomer(ClientRequestDTO clientRequest) {
		CustomerEntity customerEntity = modelMapper.map(clientRequest, CustomerEntity.class);
		customerRepository.save(customerEntity);
	}

	@Override
	public void updateAddress(AddressDTO addressRequest) {
		AddressEntity addressEntity = modelMapper.map(addressRequest, AddressEntity.class);
		customerRepository.findById(addressEntity.getClientID()).orElseThrow(()-> new CustomerNotFoundException(ErrorCodes.CUSTOMER_NOT_FOUND.getCode(),
				String.format("Customer with CustomerId %s not found.", addressEntity.getClientID())));
		
		addressRepository.save(addressEntity);
	}

}
