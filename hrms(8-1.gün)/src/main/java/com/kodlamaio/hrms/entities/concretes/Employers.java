package com.kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodlamaio.hrms.core.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
 @Entity
 @JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
 @Table(name="employers")
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
 
public class Employers extends Users {
	
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="user_id")
	//int userId;
	
	@Column(name="company_name")
	String companyName;
	
	@Column(name="website")
	String website;
	
	@Column(name="phone_number")
	String phoneNumber;
	
	@OneToMany(mappedBy = "employers")
	private List<JobAdverts> jobAdverts;

}
