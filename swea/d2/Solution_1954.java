package com.ssafy.swea.d2;

import java.util.Scanner;

public class Solution_1954 {

	static int[][] m;
	static int num;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0,-1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
				
		for (int testCase = 1; testCase <= T; testCase++) {
			num = sc.nextInt();
			m = new int[num][num];
			
			snail();
			
			sb.append("#").append(testCase).append("\n");
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					sb.append(m[i][j]).append(" ");
				}
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}
	private static void snail() {
		int number = 1;
		int direction = 0;
		int x = 0, y = 0;
		while(number < (num*num)) {
			m[x][y] = number;
			int next_x = x+dx[direction];
			int next_y = y+dy[direction];
			
			if(next_x <num && next_x >=0 && next_y < num && next_y >=0 && m[next_x][next_y] == 0) {
				x = next_x;
				y = next_y;
				number++;
			}else {
				direction = (direction+1)%4;
			}
		}
		m[x][y] = number;
		
	}

}
