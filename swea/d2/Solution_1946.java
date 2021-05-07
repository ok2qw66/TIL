package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int count = Integer.parseInt(br.readLine());
			int check = 0;
			sb.append("#").append(testCase).append("\n");
			for (int i = 0; i < count; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String alpha = st.nextToken();
				int repeat = Integer.parseInt(st.nextToken());
				
				while(repeat-- != 0) {
					sb.append(alpha);
					check++;
					
					if(check% 10 == 0) {
						sb.append("\n");
					}
				}
			}
            sb.append("\n");
		}
		System.out.println(sb);

	}

}
