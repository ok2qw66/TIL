package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1288 {

	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int number = Integer.parseInt(br.readLine());
			check = new boolean[10];
			int temp = 0;
			
			while(isContinued()) {
				temp += number;
				String len = String.valueOf(temp);
				for (int i = len.length()-1; i >= 0; i--) {
					check[Integer.parseInt(String.valueOf(len.charAt(i)))] = true;
				}
			}
			sb.append("#").append(testCase).append(" ").append(temp).append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean isContinued() {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if(!check[i])
				return true;
		}
		return false;
	}

}
