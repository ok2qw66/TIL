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
			int P = Integer.parseInt(st.nextToken()); // A�� 1���ʹ� �ݾ�
			int Q = Integer.parseInt(st.nextToken()); // B �⺻���
			int R = Integer.parseInt(st.nextToken()); // R ���� ����
			int S = Integer.parseInt(st.nextToken()); // �ʰ��� 1���ʹ� �ݾ�
			int W = Integer.parseInt(st.nextToken()); // ��� ����
			
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
