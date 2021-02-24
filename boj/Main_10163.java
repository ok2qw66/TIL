package com.ssafy.boj;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] board = new int[101][101];
		
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			int xx =Integer.parseInt(st.nextToken());
			int yy =Integer.parseInt(st.nextToken());
			
			for (int row = 0; row < xx; row++) {
				for (int col = 0; col < yy; col++) {
					board[x+row][y+col] = i;
				}
			}
		}
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				count[board[i][j]]++;
			}
		}
		
		for (int i = 1; i < count.length; i++) {
			sb.append(count[i]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	

}
