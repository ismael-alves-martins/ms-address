package br.com.pan.address.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class StateResponseDTO extends BaseInfoAddressResponseDTO implements Comparable<StateResponseDTO> {

	private RegiaoDTO regiao;

	@Override
	public int compareTo(StateResponseDTO o) {
		if (o.getSigla().equals("SP") || o.getSigla().equals("RJ")) {
			return -1;
		} else {
			return this.getSigla().compareTo(o.getSigla());
		}
	}
}
