package com.nik.tutorial.dsnalgo;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		int[] intArray = new int[10];
		intArray[0] = 10;
		for(int i=0;i<10;i++) {
			intArray[i]=i;
		}
		
		for(int i=0;i<intArray.length;i++) {
			System.out.println(intArray[i]);
		}
		
		//java 8
        Arrays.stream(intArray).forEach(System.out::println);
	}	
}
