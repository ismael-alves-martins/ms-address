package br.com.pan.address.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.address.dto.response.CepResponseDTO;
import br.com.pan.address.dto.response.CityResponseDTO;
import br.com.pan.address.dto.response.StateResponseDTO;

@Service
public class AddressProxy {

	@Autowired
	private CepServiceClient addressClient;
	
	@Autowired
	private StateServiceClient stateServiceClient;
	
	public CepResponseDTO getAddressByCep(String cep) {
		return addressClient.searchAddressByCep(cep).getBody();
	}

	public List<StateResponseDTO> getStates() {
		return stateServiceClient.getStates().getBody();
	}
	
	public List<CityResponseDTO> getCityByState(String stateId) {
		return stateServiceClient.getCityByState(stateId).getBody();
	}
}
