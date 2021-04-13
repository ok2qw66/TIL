package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] wvList = new int[N+1][2];
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wvList[i][0] = Integer.parseInt(st.nextToken());
			wvList[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { //i번째 물건 선택
			for (int j = 1; j <= K; j++) {
				if(wvList[i][0] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-wvList[i][0]]+wvList[i][1], dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
