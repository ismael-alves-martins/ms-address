package br.com.pan.address.services;

import java.util.List;

import br.com.pan.address.dto.response.CepResponseDTO;
import br.com.pan.address.dto.response.CityResponseDTO;
import br.com.pan.address.dto.response.StateResponseDTO;

public interface AddressService {

	CepResponseDTO searchAddressByCep(String cep);

	List<StateResponseDTO> getStateList();

	List<CityResponseDTO> getCityByState(String stateId);
}
