package com.ssafy.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683 {

	private static int N,M;
	private static int answer;
	private static int[][] cctv;
	private static int cctvIdx;
	private static int[][] d = { //시계반대방향
			{0,1},
			{-1,0},
			{0,-1},
			{1,0},
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] area = new int[N][M];
		answer = N*M;
		cctv = new int[8][2];
		cctvIdx=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int current = Integer.parseInt(st.nextToken());
				area[i][j] = current;
				if(current != 0 && current != 6) { // cctv라면
					cctv[cctvIdx][0] = i;
					cctv[cctvIdx++][1] = j;					
				}
			}
		}
		setCCTV(0,area);
		System.out.println(answer);
	}

	private static void setCCTV(int idx, int[][] area) {
		if(idx==cctvIdx) {
			findAnswer(area);
			return;
		}
		
		switchDirection(idx,area);
	}

	private static void findAnswer(int[][] area) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//System.out.print(area[i][j]+" ");
				if(area[i][j]==0)	count++;
			}
			//System.out.println();
		}
		answer = Math.min(answer, count);
	}

	private static void switchDirection(int idx, int[][] area) {
		int[] curr = cctv[idx];
		int[] directions = null;
		int count=0;
		switch (area[curr[0]][curr[1]]) {
		case 1:
			directions = new int[]{0};
			count = 4;
			break;
		case 2:
			directions = new int[]{0,2};
			count = 2;
			break;
		case 3:
			directions = new int[]{0,1};
			count = 4;
			break;
		case 4:
			directions = new int[]{0,1,2};
			count = 4;
			break;
		case 5:
			directions = new int[]{0,1,2,3};
			count = 1;
			break;
		}
		
		for (int i = 0; i < count; i++) {
			if(answer==0) return;
			rotate(directions); //cctv 돌리기
			int[][] clone = copy(area);
			for (int dd : directions) {
				watch(dd,curr,clone); //감시하기
			}
			setCCTV(idx+1, clone);
		}
		
	}

	private static void watch(int dd, int[] curr, int[][] clone) {
		int x = curr[0];
		int y = curr[1];
		while(true) {
			x += d[dd][0];
			y += d[dd][1];
			if(x<0 || x>=N || y<0 || y>=M || clone[x][y]==6) return;
			if(clone[x][y]==0)	clone[x][y] = -1;
		}
		
	}

	private static void rotate(int[] directions) {
		for (int i = 0; i < directions.length; i++) {
			directions[i] = (++directions[i])%4;
		}
	}

	private static int[][] copy(int[][] area) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = area[i][j];
			}
		}
		return temp;
	}

}
