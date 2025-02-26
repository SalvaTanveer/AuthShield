package com.example.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tokens")
public class Tokens {
	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDetails user;
	
	@Column
	private String otp;
	
	@Column
	private LocalDateTime createdAt;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Tokens(UserDetails user, String otp, LocalDateTime createdAt) {
		super();
		this.user = user;
		this.otp = otp;
		this.createdAt = createdAt;
	}

	public Tokens() {
		// TODO Auto-generated constructor stub
	}

	public Tokens(int id, UserDetails user, String otp, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.otp = otp;
		this.createdAt = createdAt;
	}
}
