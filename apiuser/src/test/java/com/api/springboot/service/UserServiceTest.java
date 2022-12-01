package com.api.springboot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.springboot.entity.User;
import com.api.springboot.entity.UserGender;
import com.api.springboot.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	private UserService underTest;
	
	@BeforeEach
	void setUp() {
		underTest = new UserServiceImpl();
	}
	
	@Test
	void testGetAllUsersList() {
		//when
		underTest.getAllUsersList();
		//then
		verify(userRepository).findAll();
	} 
	
	@Test
	void canAddUser() {
		//given
		User user = new User("Mar1Nani",LocalDate.of(1997, 1, 1), "french", "0698448478",UserGender.MALE);
		//when
		underTest.save(user);
		//then
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		verify(userRepository).save(userArgumentCaptor.capture());
		
		User capturedUser = userArgumentCaptor.getValue();
		assertThat(capturedUser).isEqualTo(user);
	}
	
	@Test
    void isNotAdult() {
        User user = new User();
        user.setUsername("aa");
        user.setBirthDate(LocalDate.of(2020, Month.JANUARY, 1));
        user.setCountry("french");
        UserValidator.ValidationResult result = underTest.isValidAge(user);
        assertEquals(UserValidator.ValidationResult.IS_NOT_ADULT.toString(),result.toString());
    }
	
	@Test
    void isNotFrench() {
        User user = new User();
        user.setUsername("Marou");
        user.setBirthDate(LocalDate.of(1997, Month.JANUARY, 1));
        user.setCountry("spanish");
        UserValidator.ValidationResult result = underTest.isValidCountry(user);
        assertEquals(UserValidator.ValidationResult.IS_NOT_FRENCH_RESIDENT.toString(),result.toString() );
    }


}
