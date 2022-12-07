package com.xworkz.program;

public class DublicateRemove {
	public static void main(String[] args) {
		int [] num=new int[] {0,1,2,3,0};
		int a=0;
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				if(num[i]==num[j]) {
					a++;
				}	
			}
			if(a>0) {
				System.out.println(a);
			}
			else {
				System.out.println("Not found");
			}
			
		}
			
	}

}
