package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499 {

	private static int[][] board;
	private static int[] dice = new int[6];
	private static int[] diceDownUp = new int[] {0, 4, 5, 1};
	private static int[] diceWestEast = new int[] {0, 3, 5, 2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int[][] dxy = {
				{0,0},
				{0,1},
				{0,-1},
				{-1,0},
				{1,0},
		};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		int[] diceLoc = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < T; i++) {
			int direction = Integer.parseInt(st.nextToken());
			rollDice(direction);
			
			int nx = diceLoc[0]+dxy[direction][0];
			int ny = diceLoc[1]+dxy[direction][1];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
				if(direction%2==0) {
					rollDice(direction-1);
				}else {
					rollDice(direction+1);
				}
				continue;
			}
			else if(board[nx][ny] == 0) {
				board[nx][ny] = dice[diceDownUp[2]];
			}else {
				dice[diceDownUp[2]] = board[nx][ny];
				board[nx][ny] = 0;
			}
			
			diceLoc[0] = nx;
			diceLoc[1] = ny;
					
			sb.append(dice[diceDownUp[0]]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}
	
	private static void rollDice(int direction) {
		int pre,pos;
		switch (direction) {
		case 1: // 동쪽
			pre = diceWestEast[3];
			for (int i = 3; i >0; i--) {
				pos = diceWestEast[i-1];
				diceWestEast[i-1] = pre;
				pre = pos;
			}
			diceWestEast[3] = pre;
			diceDownUp[0] = diceWestEast[0];
			diceDownUp[2] = diceWestEast[2];
			break;
		case 2: // 서쪽
			pre = diceWestEast[0];
			for (int i = 0; i < 3; i++) {
				pos = diceWestEast[i+1];
				diceWestEast[i+1] = pre;
				pre = pos;
			}
			diceWestEast[0] = pre;
			diceDownUp[0] = diceWestEast[0];
			diceDownUp[2] = diceWestEast[2];
			break;
		case 3: // 북쪽
			pre = diceDownUp[3];
			for (int i = 3; i >0; i--) {
				pos = diceDownUp[i-1];
				diceDownUp[i-1] = pre;
				pre = pos;
			}
			diceDownUp[3] = pre;
			diceWestEast[0] = diceDownUp[0];
			diceWestEast[2] = diceDownUp[2];
			break;
		default: // 남쪽
			pre = diceDownUp[0];
			for (int i = 0; i < 3; i++) {
				pos = diceDownUp[i+1];
				diceDownUp[i+1] = pre;
				pre = pos;
			}
			diceDownUp[0] = pre;
			diceWestEast[0] = diceDownUp[0];
			diceWestEast[2] = diceDownUp[2];
		}
		
	}

}
