package br.com.pan.address.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.address.dto.request.ClientRequestDTO;
import br.com.pan.address.dto.response.AddressDTO;
import br.com.pan.address.dto.response.CustomerResponseDTO;
import br.com.pan.address.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/v1/customer/{cpf}")
	public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerByCpf(cpf));
	}
	
	@GetMapping("/v1/customer")
	public ResponseEntity<List<CustomerResponseDTO>> getAllClients() {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllClients());
	}
	
	@PostMapping("/v1/customer")
	public ResponseEntity<Void> saveClient(@RequestBody ClientRequestDTO clientRequest) {
		customerService.saveCustomer(clientRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/v1/customer/address")
	public ResponseEntity<Void> updateAddress(@RequestBody AddressDTO addressRequest) {
		customerService.updateAddress(addressRequest);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
