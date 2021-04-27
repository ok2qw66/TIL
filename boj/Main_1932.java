package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int[] dp = new int[N+1];
		int[] input = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= i; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = i; j >0 ; j--) {
				dp[j] = Math.max(dp[j],dp[j-1])+input[j];
				max = Math.max(dp[j], max);
			}
			//System.out.println(Arrays.toString(dp));
			
		}
		System.out.println(max);
	}

}
