package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2491 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][2];
		int[] sequence = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp[0], 1);
		
		int maxLen = 1;
		for (int i = 1; i < N; i++) {
			if(sequence[i-1] <= sequence[i])
				dp[i][0] = dp[i-1][0]+1;
			else
				dp[i][0] = 1;
			
			if(sequence[i-1] >= sequence[i])
				dp[i][1] = dp[i-1][1]+1;
			else
				dp[i][1] = 1;
			
			int temp = Math.max(dp[i][0], dp[i][1]);
			maxLen = Math.max(maxLen, temp);
		}
		System.out.println(maxLen);
	}

}
