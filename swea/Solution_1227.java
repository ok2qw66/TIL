package com.ssafy.subclass.preview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1227 {
	private static int[][] maze;
	private static boolean[][] visited;
	private static int[] start = new int[2];
	private static int[] end = new int[2];
	private static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			int testCase = Integer.parseInt(br.readLine());
			maze = new int[100][100];
			visited = new boolean[100][100];
			answer = 0;
			
			for (int j = 0; j < 100; j++) {
				String line = br.readLine();
				for (int k = 0; k < 100; k++) {
					maze[j][k] = Integer.parseInt(String.valueOf(line.charAt(k)));
					if(maze[j][k] == 2) {
						start[0] = j;
						start[1] = k;
					}else if(maze[j][k] == 3) {
						end[0] = j;
						end[1] = k;
					}else if(maze[j][k] == 1) {
						visited[j][k] = true;
					}
				}
			}
			
			travel(start[0],start[1]);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	private static void travel(int x, int y) {
		visited[x][y] = true;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		for (int i = 0; i < 4 && answer==0; i++) {
			if(x+dx[i] == end[0] && y+dy[i] == end[1]) {
				answer = 1;
				return;
			}
			if(!visited[x+dx[i]][y+dy[i]]) {
				travel(x+dx[i], y+dy[i]);
			}
		}
	}

}
