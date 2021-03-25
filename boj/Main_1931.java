package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931 {
	static class lecture implements Comparable<lecture>{
		int start;
		int end;
		
		public lecture(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(lecture o) {
			if(this.start == o.start)
				return this.end - o.end;
			return this.start - o.start;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		lecture[] lectureList = new lecture[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			lectureList[i] = new lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lectureList);
		
		int[] dp = new int[N+1];
		
		for (int i = 1; i <=N; i++) {
			if(lectureList[i-1].end <= lectureList[i].start && dp[i-1]+1<dp[i]) {
				dp[i] = dp[i-1]+1;
			}
		}

	}

}
