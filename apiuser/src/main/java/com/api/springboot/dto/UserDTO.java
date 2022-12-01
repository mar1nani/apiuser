package com.api.springboot.dto;

import java.time.LocalDate;

import com.api.springboot.entity.UserGender;

public class UserDTO {		
	
		private Long id;
		
		private String username;

		private LocalDate birthDate;
		
		private String country;
		
		private String phoneNumber;
		private UserGender gender;
		
		
		public UserDTO() {

		}
		
		public UserDTO(String username, LocalDate birthDate, String country, String phoneNumber, UserGender gender) {
			this.username = username;
			this.birthDate = birthDate;
			this.country = country;
			this.phoneNumber = phoneNumber;
			this.gender = gender;
		}
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public LocalDate getBirthDate() {
			return birthDate;
		}
		
		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}
		
		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}
		
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public UserGender getGender() {
			return gender;
		}
		
		public void setGender(UserGender gender) {
			this.gender = gender;
		}
		
	}
