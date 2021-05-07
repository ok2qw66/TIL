package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1940 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			int[] move = new int[2];
			
			int num = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine()," ");
				
				int check = Integer.parseInt(st.nextToken());
				
				switch (check) {
				case 1:
					move[0] += Integer.parseInt(st.nextToken());
					break;
				case 2: 
					if((move[0] -= Integer.parseInt(st.nextToken()))<0)
						move[0] = 0;
					break;
				}
				move[1] += move[0];
			}
			sb.append("#").append(testCase).append(" ").append(move[1]).append("\n");
		}
		System.out.println(sb);
	}

}
