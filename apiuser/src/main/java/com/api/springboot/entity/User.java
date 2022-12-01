package com.api.springboot.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;


@Entity(name = "User")
@Table(name = "Users")
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
	
	
	public User() {

	}
	
	public User(@NotBlank(message = "Username is mandatory") String username,@PastOrPresent LocalDate birthDate, @NotBlank(message = "country of residence is mandatory") String country, String phoneNumber, UserGender gender) {
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
	
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    
	    if (!(o instanceof User))
	      return false;
	    
	    User user = (User) o;
	    
	    return Objects.equals(this.id, user.id) 
	    	&& Objects.equals(this.username, user.username)
	        && Objects.equals(this.birthDate, user.birthDate)
	        && Objects.equals(this.country, user.country)
	        && Objects.equals(this.phoneNumber, user.phoneNumber)
	        && Objects.equals(this.gender, user.gender);
	  }

	@Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.username, this.birthDate, this.country, this.phoneNumber, this.gender);
	  }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthDate=" + birthDate + ", country=" + country
				+ ", phoneNumber=" + phoneNumber + ", gender=" + gender + "]";
	}

	
	
	
}
