package br.com.pan.address.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pan.address.dto.response.CityResponseDTO;
import br.com.pan.address.dto.response.StateResponseDTO;

@FeignClient(name = "state-service", url = "${service-clients.state.url}")
public interface StateServiceClient {

	@RequestMapping(value = "/v1/localidades/estados/", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<StateResponseDTO>> getStates();
	
	@RequestMapping(value = "/v1/localidades/estados/{stateId}/municipios", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<CityResponseDTO>> getCityByState(@PathVariable(value="stateId") String stateId);
}
