package com.ssafy.boj;

import java.util.Scanner;

public class Main_11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		int[] dp = new int[1001];
		
		dp[1] = 1; //1칸일때는 1가지 경우
		dp[2] = 2; //2칸일때는 2가지 경우
		
		for (int i = 3; i <=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[N]);
		sc.close();
	}

}
