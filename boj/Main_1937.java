package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1937 {
	private static int[][] bambooArea;
	private static int[][] expectDP;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		bambooArea = new int[N][N];
		expectDP = new int[N][N];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				bambooArea[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.max(answer,goPanda(i,j));
			}
		}
		System.out.println(answer);
	}
	
	private static int goPanda(int i, int j) {
		if(expectDP[i][j]==0) {
			int add = 0;
			for (int k = 0; k < 4; k++) {
				int ni = i + dx[k];
				int nj = j + dy[k];
				
				if(ni<0 || ni>=N ||  nj<0 || nj>=N) continue;
				if(bambooArea[ni][nj]> bambooArea[i][j]) {
					add = Math.max(add,goPanda(ni, nj));
				}
			}
			expectDP[i][j] = add+1;
		}
		return expectDP[i][j];
	}

}
