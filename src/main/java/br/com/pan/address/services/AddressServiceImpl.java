package br.com.pan.address.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.pan.address.clients.AddressProxy;
import br.com.pan.address.constants.ErrorCodes;
import br.com.pan.address.dto.response.CepResponseDTO;
import br.com.pan.address.dto.response.CityResponseDTO;
import br.com.pan.address.dto.response.StateResponseDTO;
import br.com.pan.address.exception.ResourceNotFoundException;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressProxy addressProxy;
	
	@Override
	public CepResponseDTO searchAddressByCep(String cep) {
		CepResponseDTO addressByCep = addressProxy.getAddressByCep(cep);
		if (addressByCep == null || addressByCep.getCep() == null) {
			throw new ResourceNotFoundException(ErrorCodes.RESOURCE_NOT_FOUND.getCode(),
					String.format("CEP %s not found.", cep));
		}
		return addressByCep;
	}
	
	@Override
	public List<StateResponseDTO> getStateList() {
		final List<StateResponseDTO> orderedStates = new ArrayList<>();
		List<StateResponseDTO> states = addressProxy.getStates();
		
		states.sort((s1, s2) -> s1.getSigla().compareTo(s2.getSigla()));
		orderedStates.addAll(states);
		states.stream().forEach(s -> {
			if(s.getSigla().equals("SP") || s.getSigla().equals("RJ")) {
				orderedStates.remove(s);
				orderedStates.add(0, s);
			} 
		});
		return orderedStates;
	}

	@Override
	public List<CityResponseDTO> getCityByState(String stateId) {
		List<CityResponseDTO> cityByState = addressProxy.getCityByState(stateId);
		if (CollectionUtils.isEmpty(cityByState)) {
			throw new ResourceNotFoundException(ErrorCodes.RESOURCE_NOT_FOUND.getCode(),
					String.format("No cities were found with this stateId: %s ", stateId));
		}
		return cityByState;
	}
}
