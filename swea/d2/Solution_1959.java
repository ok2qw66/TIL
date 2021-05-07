package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1959 {
	public static int[] a;
	public static int[] b;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = new int[Integer.parseInt(st.nextToken())];
			b = new int[Integer.parseInt(st.nextToken())];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int index = 0;index<a.length;index++) {
				a[index] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int index = 0;index<b.length;index++) {
				b[index] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			if(a.length > b.length) {
				sum = multi(a,b);
			}else {
				sum = multi(b,a);
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static int multi(int[] more, int[] less) {
		int sum = 0;
	
		for (int i = 0,len = less.length, border = more.length; i + len -1 < border; i++) {
			int temp = 0;
			for (int j = 0; j < len; j++) {
				temp += more[i+j] * less[j];
			}
			sum = Math.max(temp, sum);
		}
		return sum;
	}

}
