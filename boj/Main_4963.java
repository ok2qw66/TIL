package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963 {

	private static boolean[][] visited;
	private static int[][] world;
	private static int[] dx = {0,0,1,-1,-1,-1,1,1};
	private static int[] dy = {-1,1,0,0,-1,1,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line;
		while(!(line=br.readLine()).equals("0 0")) {
			st = new StringTokenizer(line, " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int count = 0;
			
			world = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					world[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && world[i][j]==1) {
						findLand(i,j);
						count++;
						
//						for (int ii = 0; ii < h; ii++) {
//							for (int jj = 0; jj < w; jj++) {
//								System.out.print(visited[ii][jj]+" ");
//							}
//							System.out.println();
//						}
					}
				}
			}
			System.out.println(count);
		}
		

	}

	private static void findLand(int x, int y) {
		
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		
		visited[x][y] = true;
		queue.add(new Integer[] {x,y});
		
		while(!queue.isEmpty()) {
			Integer[] pick = queue.poll();
			
			//System.out.println(Arrays.toString(pick));
			
			for (int i = 0; i < 8; i++) {
				int nx = pick[0] + dx[i];
				int ny = pick[1] + dy[i];
				
				if(nx<0 || nx >= visited.length || ny <0 || ny >= visited[0].length) continue;
				if(!visited[nx][ny] && world[nx][ny]==1) {
					visited[nx][ny] = true;
					queue.add(new Integer[] {nx,ny});
				}
			}

		}
		
	}

}
