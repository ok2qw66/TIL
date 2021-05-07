package com.ssafy.swea.d2;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		System.out.println("ют╥б");
		T = sc.nextInt();
		
		for( int test_case=1; test_case<=T; test_case++) {
			int[] hourMin = new int[4];
			
			for( int i=0; i< hourMin.length; i++)
				hourMin[i] = sc.nextInt(); 
			
			int totalHour = hourMin[0] + hourMin[2];
			int totalMin = hourMin[1] + hourMin[3];
			
			if (totalMin >= 60) {
				totalHour++;
				totalMin -= 60;
			}
			
			totalHour = totalHour>12?totalHour-12:totalHour;
			
			System.out.println("#"+test_case+" "+totalHour+" "+totalMin);
		}
		sc.close();
	}
}
