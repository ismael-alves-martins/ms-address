package br.com.pan.address.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.address.dto.response.CepResponseDTO;
import br.com.pan.address.dto.response.CityResponseDTO;
import br.com.pan.address.dto.response.StateResponseDTO;
import br.com.pan.address.services.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@GetMapping("/v1/cep/{cep}")
	public ResponseEntity<CepResponseDTO> getAddressByCep(@PathVariable String cep) {
		return ResponseEntity.status(HttpStatus.OK).body(addressService.searchAddressByCep(cep));
	}
	
	@GetMapping("/v1/states")
	public ResponseEntity<List<StateResponseDTO>> getStatesList() {
		return ResponseEntity.status(HttpStatus.OK).body(addressService.getStateList());
	}
	
	@GetMapping("/v1/states/{stateId}/city")
	public ResponseEntity<List<CityResponseDTO>> getCityByState(@PathVariable String stateId) {
		return ResponseEntity.status(HttpStatus.OK).body(addressService.getCityByState(stateId));
	}

}
