package br.com.pan.address.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pan.address.dto.response.CepResponseDTO;

@FeignClient(name = "address-service", url = "${service-clients.cep.url}")
public interface CepServiceClient {

	@RequestMapping(value = "/ws/{cep}/json", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<CepResponseDTO> searchAddressByCep(@PathVariable(value="cep") String cep);
}
