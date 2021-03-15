package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_14502 {

	private static int[][] area;
	private static ArrayList<Integer[]> available;
	private static int[][] d = {{0,-1},{0,1},{1,0},{-1,0}};
	private static int N;
	private static int M;
	private static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		area = new int[N+2][M+2];
		available = new ArrayList<>();
		
		for (int j = 0; j < N+2; j++) {
			area[j][0] = 1;
			area[j][M+1] = 1;
		}
		for (int j = 0; j < M+2; j++) {
			area[0][j] = 1;
			area[N+1][j] = 1;
		}
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M+1; j++) {
				int val = Integer.parseInt(st.nextToken());
				area[i][j] = val;
				
				if(val == 0) {
					available.add(new Integer[] {i,j});
				}
			}
		}
		
		combination(0,0);
		System.out.println(answer);
	}
	
	private static void combination(int idx, int cnt) {
		if(cnt ==3) {
			spread();
			return;
		}
		Integer[] temp;
		for (int i = idx; i < available.size(); i++) {
			temp = available.get(i);
			area[temp[0]][temp[1]] = 1;
			combination(i+1, cnt+1);
			area[temp[0]][temp[1]] = 0;
		}
		
	}

	private static void spread() {
		int cnt = 0;
		int[][] clone = new int[N+2][M+2];		
		Stack<Integer[]> virus = new Stack<Integer[]>();
		
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < M+2; j++) {
				int val = area[i][j];
				clone[i][j] = val;
				
				if(val == 2) {
					virus.add(new Integer[] {i,j});
				}
			}
		}
		
		//System.out.println("SPREAD>>>>>>>>>>>>>>");
		
		while(!virus.isEmpty()) {
			Integer[] v = virus.pop();
			//System.out.println(v[0] + " "+ v[1]);
			
			for (int i = 0; i < 4; i++) {
				if(clone[v[0]+d[i][0]][v[1]+d[i][1]] == 0) {
					clone[v[0]+d[i][0]][v[1]+d[i][1]] = 2;
					virus.add(new Integer[] {v[0]+d[i][0],v[1]+d[i][1]});
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				if(clone[i][j] == 0) {
					cnt ++;
				}
			}
		}
		
		answer = answer < cnt ? cnt: answer;
		
		return;
		
	}


}