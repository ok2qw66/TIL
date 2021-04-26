package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018 {

	private static int answer=Integer.MAX_VALUE;
	private static char[][] board;
	private static char[] check = new char[] {'W','B'};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i+7 < N; i++) {
			for (int j = 0; j+7 < M; j++) {
				goChess(i,j);
			}
		}
		System.out.println(answer);
	}
	private static void goChess(int startX, int startY) {
		int current;
		
		for (int start = 0; start<2;start++) {
			int count = 0;
			for (int i = 0; i < 8; i++) {
				if(i%2==0) current = start;
				else	current = (start+1)%2;
				for (int j = 0; j < 8; j++) {
					int newX = startX + i;
					int newY = startY + j;
					
					if(board[newX][newY]!=check[current]) count++;
					current = (current+1)%2;
				}
			}
			//System.out.println("count = "+count);
			answer = Math.min(answer, count);
		}
		
		
	}

}
