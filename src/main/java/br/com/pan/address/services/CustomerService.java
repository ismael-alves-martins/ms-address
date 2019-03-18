package br.com.pan.address.services;

import java.util.List;

import br.com.pan.address.dto.request.ClientRequestDTO;
import br.com.pan.address.dto.response.AddressDTO;
import br.com.pan.address.dto.response.CustomerResponseDTO;

public interface CustomerService {

	public CustomerResponseDTO getCustomerByCpf(String cpf);

	public List<CustomerResponseDTO> getAllClients();

	public void saveCustomer(ClientRequestDTO clientRequest);
	
	void updateAddress(AddressDTO addressRequest);
}
