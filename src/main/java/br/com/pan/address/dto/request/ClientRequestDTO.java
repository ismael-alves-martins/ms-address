package br.com.pan.address.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.pan.address.dto.response.AddressDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientRequestDTO {

	private String firstName;

	private String lastName;

	private String cpf;

	private List<AddressDTO> address;
}
