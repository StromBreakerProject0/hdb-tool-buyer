package com.hdbtool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Data
public class User extends Auditable<String> {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "userType", nullable = false)
	private UserType userType;

	@Column(name = "userName", nullable = false)
	private String userName;

	private String email;
	private String phoneNumber;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "isActive", nullable = false, columnDefinition = "Boolean default true")
	private Boolean isActive;
}
