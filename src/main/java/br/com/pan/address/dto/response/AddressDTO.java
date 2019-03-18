package br.com.pan.address.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {

	private Integer id;

	private String street;
	
	private String district;
	
	private String postalCode;
	
	private String complement;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private Integer clientID;
}
