package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Tokens;


@Repository
public interface TokenRepository extends JpaRepository<Tokens, Integer>{
	Tokens findByOtp(String otp);
}
