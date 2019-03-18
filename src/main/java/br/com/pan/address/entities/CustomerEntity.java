package br.com.pan.address.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CLIENT")
@DynamicUpdate
@Data
@EqualsAndHashCode(callSuper=false)
public class CustomerEntity extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "CPF")
	private String cpf;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "CLIENT_ID", insertable=true, updatable=true)
	private List<AddressEntity> address;
}
