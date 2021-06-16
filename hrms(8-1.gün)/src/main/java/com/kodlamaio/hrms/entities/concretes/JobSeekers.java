package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.core.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class JobSeekers extends Users{

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "user_id")
	//int userId;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "national_idendity_number")
	private String identityNumber;

	@Column(name="date_of_birth")
	private int dateOfBirth;

	//@Transient //It means that a field in the Entity class will not have a column counterpart in the database.
	// private String passwordValidation;
	
	/*@JsonIgnore
	@Column(name="is_verified")
	private boolean isVerified = false;*/
}
