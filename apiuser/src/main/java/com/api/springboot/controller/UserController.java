package com.api.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.dto.UserDTO;
import com.api.springboot.entity.User;
import com.api.springboot.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/users")
	public ResponseEntity<?> all() {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		List<User> listofUser = userService.getAllUsersList();
		List<UserDTO> listofUserDto = new ArrayList<UserDTO>();
		if (!listofUser.isEmpty()) {
			for (User user : listofUser) {
				listofUserDto.add(modelMapper.map(user, UserDTO.class));
			}
			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("data", listofUserDto);
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
		} else {
			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "No User has been found");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody @Valid User user) {
		return userService.save(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDto) {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
			User user = userService.findById(id);
			user.setUsername(userDto.getUsername());
			user.setCountry(userDto.getCountry());
			user.setBirthDate(userDto.getBirthDate());
			user.setPhoneNumber(userDto.getPhoneNumber());
			user.setGender(userDto.getGender());
			userService.save(user);
			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("data", userService.findById(id));
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		try {
			User user = userService.findById(id);
			userService.delete(user);
			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("message", "User is deleted successfully!");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
		} catch (Exception ex) {
			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "There is no User with id " + id);
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
