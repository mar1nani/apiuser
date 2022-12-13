package com.api.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.springboot.entity.User;
import com.api.springboot.exception.AgeFoundException;
import com.api.springboot.exception.CountryFoundException;
import com.api.springboot.exception.NoDataFoundException;
import com.api.springboot.exception.UserNotFoundException;
import com.api.springboot.repository.UserRepository;
import com.api.springboot.service.UserValidator.ValidationResult;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	 @Autowired
	 private UserRepository userRepository;

	@Override
	public List<User> getAllUsersList() {
		var users = (List<User>) userRepository.findAll();
		if(users.isEmpty()) {
			throw new NoDataFoundException();
		}
		return users;
	}

	@Override
	public User save(User user) {
        UserValidator.ValidationResult resultCountry = isValidCountry(user);
        UserValidator.ValidationResult resultAge = isValidAge(user);
        
        if (resultCountry != UserValidator.ValidationResult.SUCCESS){
        	throw new CountryFoundException();
        }else if(resultAge != UserValidator.ValidationResult.SUCCESS) {
        	throw new AgeFoundException();
        }
        	
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
		
	}

	@Override
	public ValidationResult isValidCountry(User user) {
		UserValidator.ValidationResult result = UserValidator.userIsFrench()
                .apply(user);
         return result;
	}
	
	@Override
	public ValidationResult isValidAge(User user) {
		UserValidator.ValidationResult result = UserValidator.userIsOverAge()
                .apply(user);
         return result;
	}

}
