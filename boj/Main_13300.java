package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[][] room = new int [7][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			room[y][s]++;
		}
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < 2; j++) {
				if(room[i][j]%K ==0) {
					answer+= room[i][j]/K;
				}else {
					answer += room[i][j]/K +1;
				}
			}
		}
		System.out.println(answer);
	}

}
