package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1945 {
	static int[] check = {2, 3, 5, 7, 11};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int number = Integer.parseInt(br.readLine());
			sb.append("#").append(testCase).append(" ");
			for (int data : check) {
				int count = 0;
				while(number%data == 0) {
					count++;
					number /= data;
				}
				sb.append(count).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
