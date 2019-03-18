package br.com.pan.address.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pan.address.entities.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

	public CustomerEntity findByCpf(String cpf);
}
