package br.com.pan.address;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
public class MsAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAddressApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
