package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17391 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> move = new LinkedList();
		move.add(new int[] {0,0});
		
		while(visited[N-1][M-1] == 0) {
			int[] present = move.poll();
			int cnt = visited[present[0]][present[1]];
			int moveCnt = map[present[0]][present[1]];
			
			//System.out.println(cnt+" "+Arrays.toString(present)+" "+moveCnt);
			
			for(int i =1;i<=moveCnt;i++) {
				int downX = present[0]+i;
				int rightY = present[1]+i;
				
				if(downX < N) {
					int down = visited[downX][present[1]];
					if(down == 0 || down > cnt+1 ) {
						visited[downX][present[1]] = cnt + 1;
						move.add(new int[] {downX, present[1]});
					}
				}
				
				if(rightY < M) {
					int right = visited[present[0]][rightY];
					if(right == 0 || right > cnt+1) {
						visited[present[0]][rightY] = cnt + 1;
						move.add(new int[] {present[0], rightY});
					}
					
				}
				
			}
		}
		
		System.out.println(visited[N-1][M-1]);
	}

}
