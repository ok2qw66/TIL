package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889 {
	private static int[] start;
	private static int[] link;
	private static int N;
	private static int answer = Integer.MAX_VALUE;
	private static int[][] synerge;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		synerge = new int[N+1][N+1];
		start = new int[N/2];
		link = new int[N/2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				synerge[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		subset(1,0);
		System.out.println(answer);
	}

	private static void subset(int num, int idx) {
		if(idx==N/2) {
			check();
			return;
		}else if(num > N)
			return;
		
		start[idx] = num;
		subset(num+1, idx+1);
		subset(num+1, idx);
		
	}

	private static void check() {
		for (int i = 1,idx=0,idx2=0; i <= N; i++) {
			if(idx >= N/2 || start[idx]!=i) {
				link[idx2] = i;
				idx2++;
			}else {
				idx++;
			}
		}
		
		int startSum = 0;
		int linkSum = 0;
		
		for (int i = 0; i < N/2-1; i++) {
			for (int j = i+1; j < N/2; j++) {
				startSum += synerge[start[i]][start[j]] + synerge[start[j]][start[i]];
				linkSum += synerge[link[i]][link[j]] + synerge[link[j]][link[i]];
			}
		}
		
		answer = Math.abs(startSum-linkSum) < answer? Math.abs(startSum-linkSum) : answer;
		
	}

}
