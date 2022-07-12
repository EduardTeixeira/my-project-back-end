package com.projectname.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
//@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
//		@UniqueConstraint(columnNames = "email") })
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "US_ID", nullable = false)
	private Long id;

	@NotBlank
	@Size(max = 100)
	@Column(name = "US_FIRSTNAME", nullable = false)
	private String firstName;

	@NotBlank
	@Size(max = 100)
	@Column(name = "US_LASTNAME", nullable = false)
	private String lastName;

	@NotBlank
	@Size(max = 100)
	@Email
	@Column(name = "US_EMAIL", nullable = false, unique = true)
	private String email;

	@NotBlank
	@Size(max = 50)
	@Column(name = "US_PASSWORD", nullable = false)
	private String password;

}
