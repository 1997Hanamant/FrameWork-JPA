package com.xworkz.program;

public class StringDuplication {
	public static void main(String[] args) {
		String s="I love java India";
		String[] string=s.split("");
		for(int i=0;i<s.length();i++) {
			int cout=1;
			for(int j=i+1;j<s.length();j++) {
				if(string[i].equals(string[j])){
					cout++;
					string[j]="0";
					
				}
			}
			if(string[i]!="0") {
				System.out.println(string[i]+"");
			}
			
		}
		

	}
}
