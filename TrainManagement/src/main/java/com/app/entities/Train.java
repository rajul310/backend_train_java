package com.app.entities;



import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok annotations

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Train extends BaseEntity {
	@Column(nullable = false)
	private String trainName;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Category trainType;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime startTime;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime end_time;
	
	private String source;
	
	@NotBlank(message = "Destination cannot be blank")
	private String destination;
	
	@Column(nullable = false)
	private int distance;
	
	@Column(nullable = false)
	private int frequency;


}
