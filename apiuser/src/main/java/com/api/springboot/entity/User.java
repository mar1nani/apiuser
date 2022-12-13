package com.api.springboot.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "User")
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "user_sequence"
			)
	
	private Long id;
	
	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@PastOrPresent(message="Date must be less than today")
	@NotNull(message="Birthdate is mandatory")
	private LocalDate birthDate;
	
	
	@NotBlank(message = "country of residence is mandatory")
	private String country;
	
	private String phoneNumber;
	private UserGender gender;
	
	
}
