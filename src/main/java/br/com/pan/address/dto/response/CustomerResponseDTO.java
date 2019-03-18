package br.com.pan.address.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResponseDTO {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String cpf;
	
	private List<AddressDTO> address;
}
