package com.xworkz.test;

import java.util.Set;
import java.util.TreeSet;

public class Duplicates {
	public static void main(String[] args) {

		Set<String> strings = new TreeSet<String>();
		strings.add("Hello");
		strings.add("hi");
		strings.add("Wow");
		strings.add("cute");
		strings.add("thanks");
		strings.add("hi");
		strings.add("Aww");
		strings.add("cute");
		strings.add("hello");
		strings.add("beloved");
		strings.add("Aww");
		System.out.println(strings);

	}
}
