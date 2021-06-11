package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {
	private static int N,L,R;
	private static int[][] land;
	private static boolean[][] isVisited;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	private static ArrayList<int[]> union = new ArrayList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		land = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 1;
		int days = -1;
		while(count!=0) {
			count = 0;
			isVisited = new boolean[N][N];
			for (int i = 0; i < N*N; i++) {
				if(!isVisited[i/N][i%N]) {
					count += checkBoundary(i/N, i%N);
				}
			}
			days++;
		}
		System.out.println(days);
	}
	
	private static int checkBoundary(int x, int y) {
		union.clear();
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		union.add(new int[] {x,y});
		isVisited[x][y] = true;
		int population = land[x][y];
		while(!q.isEmpty()) {
			int[] current = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				int diff = Math.abs(land[current[0]][current[1]]-land[nx][ny]);
				if(diff<=R && diff >=L && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true;
					q.add(new int[] {nx,ny});
					population += land[nx][ny];
					union.add(new int[] {nx,ny});
				}
			}
		}
		if(union.size()==1) return 0;
		population /= union.size();
		
		for (int[] is : union) {
			land[is[0]][is[1]] = population;
		}
		return 1;
	}

}
