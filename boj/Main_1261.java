package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261 {

	private static int N,M;
	private static int[][] maze;
	private static int[][] visited;
	private static int[][] d = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
			}
		}
		
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		djikstra(0,0);
		System.out.println(visited[N-1][M-1]);
	}

	private static void djikstra(int row, int col) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {row,col});
		visited[row][col] = 0;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = current[0] + d[dir][0];
				int nc = current[1] + d[dir][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(maze[nr][nc]==1 && visited[nr][nc]>visited[current[0]][current[1]]+1) {
					visited[nr][nc] = visited[current[0]][current[1]]+1;
					q.add(new int[] {nr,nc});
				}else if(maze[nr][nc]==0 && visited[nr][nc]>visited[current[0]][current[1]]) {
					visited[nr][nc] = visited[current[0]][current[1]];
					q.add(new int[] {nr,nc});
				}
			}
		}
	}

	
	
}
