package br.com.pan.address.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "ADDRESS")
@DynamicUpdate
@Data
@EqualsAndHashCode(callSuper=false)
public class AddressEntity extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "STREET")
	private String street;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name = "COMPLEMENT")
	private String complement;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "CLIENT_ID")
	private Integer clientID;
}
