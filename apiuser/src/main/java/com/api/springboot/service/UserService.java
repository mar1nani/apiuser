package com.api.springboot.service;

import java.util.List;

import com.api.springboot.entity.User;
import com.api.springboot.service.UserValidator.ValidationResult;

public interface UserService {

	  public List < User > getAllUsersList();

	  public User save(User user);

	  public User findById(Long id);

	  public void delete(User user);

	  ValidationResult isValidCountry(User user);

	  ValidationResult isValidAge(User user);
	}
