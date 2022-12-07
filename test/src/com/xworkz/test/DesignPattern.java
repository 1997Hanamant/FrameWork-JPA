package com.xworkz.test;

public class DesignPattern {
	public static void main(String[] args) {
		for (int i = 0; i < 22; i++) {
			for (int j = 6; j<=i; j++) {
				if (i == 0 || j == 0 || i == j || j == i) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
		}
		System.out.println();
	}

}
