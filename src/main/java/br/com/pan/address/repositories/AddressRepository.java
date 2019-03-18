package br.com.pan.address.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pan.address.entities.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{

}
