package com.bridgelabz.spring.Utility;

public interface TokenGenerator {
	public String generateToken(String id);

	public int verifyToken(String token);
}
