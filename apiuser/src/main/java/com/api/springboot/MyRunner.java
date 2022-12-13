package com.api.springboot;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.springboot.entity.User;
import com.api.springboot.entity.UserGender;
import com.api.springboot.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
public class MyRunner implements CommandLineRunner {

	 private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

	    private final UserRepository userRepository;

	    public MyRunner(UserRepository cityRepository) {
	        this.userRepository = cityRepository;
	    }
	    
	@Override
	public void run(String... args) throws Exception {
		logger.info("Saving users");

        userRepository.save(new User("Marou",LocalDate.of(1997, 8, 10), "french", "0675889487",UserGender.MALE));	
        userRepository.save(new User("Laya",LocalDate.of(2000, 2, 7), "french", "0698432216",UserGender.FEMALE));		
        userRepository.save(new User("Bruno",LocalDate.of(1992, 1, 8), "french", "0646758893",UserGender.MALE));	
        
        logger.info("Users are all saved");

	}

}
