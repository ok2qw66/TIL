package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1285 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] sizeCount;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sizeCount = new int[2];
			sizeCount[0] = Integer.MAX_VALUE;
			int people = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			while(st.hasMoreTokens()) {
				int distance = Math.abs(Integer.parseInt(st.nextToken()));
				if(sizeCount[0] > distance) {
					sizeCount[0] = distance;
					sizeCount[1] = 1;
				}else if(sizeCount[0] == distance) {
					sizeCount[1]++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(sizeCount[0]).append(" ").append(sizeCount[1]).append("\n");
		}
		System.out.println(sb);
	}
}
