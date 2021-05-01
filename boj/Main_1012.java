package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012 {
	private static boolean[][] lettuce;
	private static int M,N,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			lettuce = new boolean[M][N];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				lettuce[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			sb.append(findCnt()).append("\n");
		}
		sb.setLength(sb.length());
		System.out.println(sb);
	}
	
	private static int cnt;
	private static int findCnt() {
		cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(lettuce[i][j]) {
					gogo(i,j);
				}
			}
		}
		return cnt;
	}
	
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	private static void gogo(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x,y});
		lettuce[x][y] = false;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				
				if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
				if(lettuce[nx][ny]) {
					lettuce[nx][ny] = false;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		cnt++;
	}

}
