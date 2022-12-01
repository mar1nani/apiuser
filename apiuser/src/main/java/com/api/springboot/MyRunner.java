package com.api.springboot;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.springboot.entity.User;
import com.api.springboot.entity.UserGender;
import com.api.springboot.repository.UserRepository;

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

        userRepository.save(new User("Mar1Nani",LocalDate.of(1990, 8, 8), "oooo", "565656567",UserGender.MALE));	
        userRepository.save(new User("Mar1Nani",LocalDate.of(1990, 8, 8), "tgze", "68",UserGender.FEMALE));		
        userRepository.save(new User("Mar1Nani",LocalDate.of(1990, 8, 8), "frcerzxex", "78787",UserGender.MALE));	
        
        logger.info("Users are all saved");

	}

}
