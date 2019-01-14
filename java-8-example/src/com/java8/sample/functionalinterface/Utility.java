package com.java8.sample.functionalinterface;

public class Utility {

	public static long add(long n1, long n2){
		return n1 + n2;
	}
	
	public static long substract(long n1, long n2){
		if(n1 > n2)
			return n1 - n2;
		else
			return n2 - n1;
	}
}
