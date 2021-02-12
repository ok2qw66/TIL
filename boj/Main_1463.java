package com.ssafy.baekjoon;

import java.util.Scanner;

public class Main_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] count = new int[N+1];
		
		for (int i = 1; i < N; i++) {
			int val = count[i];
			count[i+1] = count[i+1] == 0 || count[i+1] > val+1? val+1 : count[i+1];
			if(i*2 <= N)	count[i*2] = count[i*2] == 0 || count[i*2] > val+1? val+1 : count[i*2];
			if(i*3 <= N)	count[i*3] = count[i*3] == 0 || count[i*3] > val+1? val+1 : count[i*3];
			//System.out.println(Arrays.toString(count));
		}
		System.out.println(count[N]);
	}

}
