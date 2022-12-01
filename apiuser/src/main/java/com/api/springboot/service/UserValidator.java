package com.api.springboot.service;

import com.api.springboot.entity.User;
import static com.api.springboot.service.UserValidator.*;
import java.time.Period;
import java.util.function.Function;
import java.time.LocalDate;

public interface UserValidator extends Function<User, ValidationResult> {

	String FRENCH = "french";

	static UserValidator userIsOverAge() {
		return user -> Period.between(user.getBirthDate(), LocalDate.now()).getYears() > 18 ? ValidationResult.SUCCESS
				: ValidationResult.IS_NOT_ADULT;
	}

	static UserValidator userIsFrench() {
		return user -> user.getCountry().equals(FRENCH) ? ValidationResult.SUCCESS
				: ValidationResult.IS_NOT_FRENCH_RESIDENT;
	}
	
	default UserValidator and (UserValidator other){
	       return user -> {
	           ValidationResult result = this.apply(user);
	           return result.equals(ValidationResult.SUCCESS) ? other.apply(user): result;
	       };
	    }

	enum ValidationResult {
		SUCCESS, IS_NOT_FRENCH_RESIDENT, IS_NOT_ADULT,
	}
}
