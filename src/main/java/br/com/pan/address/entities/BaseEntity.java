package br.com.pan.address.entities;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity {

	@CreationTimestamp
	@Column(name = "CREATE_DATE")
	private ZonedDateTime createDate;
	
	@UpdateTimestamp
	@Column(name = "LAST_MODIFIED_DATE")
	private ZonedDateTime lastModifiedDate;
}
