package com.payurdues.helper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class RandomIDGenerator {

	public String generateProfileID(){

		UUID uuid = null; 
		return uuid.randomUUID().toString().replaceAll("-", "");
		
	}
	
	
	
	public static void main(String[] args) {
		RandomIDGenerator generator = new RandomIDGenerator();
		generator.generateProfileID();
	}
}
