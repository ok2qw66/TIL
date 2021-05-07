package com.ssafy.swea.d2;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution_1284 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken()); // A사 1리터당 금액
			int Q = Integer.parseInt(st.nextToken()); // B 기본요금
			int R = Integer.parseInt(st.nextToken()); // R 리터 기준
			int S = Integer.parseInt(st.nextToken()); // 초과시 1리터당 금액
			int W = Integer.parseInt(st.nextToken()); // 사용 리터
			
			int a = P * W;
			int b = 0;
			if(W > R) {
				int over = W - R;
				b += over * S;
			}
			b += Q;
			
			int answer = Math.min(a, b);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
