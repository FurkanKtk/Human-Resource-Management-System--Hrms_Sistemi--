package com.kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adverts")
public class JobAdverts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	// @JsonIgnore
	private Employers employers;

	@ManyToOne
	// @JsonIgnore
	@JoinColumn(name = "job_positions_id")
	private JobPositions jobPositions;

	@ManyToOne
	@JoinColumn(name = "city_id")
	// @JsonIgnore
	private City city;

	@Column(name = "job_advert_name")
	private String jobAdvertName;

	@Column(name = "description")
	private String description;

	@Column(name = "open_position_count")
	private int openPositionCount;

	@Column(name = "application_deadline")
	private String applicationDeadline;

	@Column(name = "published_date")
	private String publishedDate;

	@Column(name = "salary_min")
	private int salaryMin;
	@Column(name = "salary_max")
	private int salaryMax;

	@Column(name = "is_active")
	private boolean isActive;

	
}
