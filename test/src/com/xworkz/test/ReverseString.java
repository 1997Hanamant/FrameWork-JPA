package com.xworkz.test;

public class ReverseString {

	public static void main(String[] args) {
	
		String input="getting good at coding needs a lot of practice";
		char[] name=input.toCharArray();
		for (int i =name.length-1;i>0; i--) {
			System.out.print(name[i]);
			
		}

	}

}
