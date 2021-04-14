package com.btype.adhoc;

import java.util.Scanner;

public class Solution_3819 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[] dp = new int[N+1];
			dp[0] = sc.nextInt();
			int max = dp[0];
			for (int i = 1; i < N; i++) {
				dp[i] = Math.max(dp[i-1], 0) + sc.nextInt();
				max = Math.max(max, dp[i]);
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
