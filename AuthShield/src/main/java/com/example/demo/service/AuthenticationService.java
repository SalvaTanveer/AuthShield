package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Tokens;
import com.example.demo.entities.UserDetails;

import com.example.demo.repositories.TokenRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class AuthenticationService {
	
	UserRepository userRepository;
	TokenRepository tokenRepository;
	JavaMailSender mailSender;
	
	@Autowired
	public AuthenticationService(UserRepository userRepository,TokenRepository tokenRepository,JavaMailSender mailSender) {
		this.userRepository=userRepository;
		this.tokenRepository=tokenRepository;
		this.mailSender = mailSender;
	}
	
	public String verifyUser(String username, String password) {
		
		UserDetails user = userRepository.findByUsername(username);
		if(user != null && password.equals(user.getPassword())) {
			//Logic of sending mail to user with otp

			Random random = new Random();
			int randomotp = random.nextInt(999999);
			String otp = String.format("%06d", randomotp);
			
			Tokens token = new Tokens();
			token.setUser(user);
			token.setOtp(otp);
			token.setCreatedAt(LocalDateTime.now());
			tokenRepository.save(token);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(user.getEmail());
			message.setSubject("Your OTP code");
			message.setText("Your OTP code is: "+otp);
			mailSender.send(message);
			
			
			
			return "success";
		}else {
			return "Failure";
		}
		
	
	}
	
	public String verify(String otp) {
		Tokens token = tokenRepository.findByOtp(otp);
		if(token != null) {
			if(ChronoUnit.MINUTES.between(token.getCreatedAt(), LocalDateTime.now())>1) {
				tokenRepository.delete(token);
				return "expired";
			}
			return "success";
		}
		return "failure";
	}
}
