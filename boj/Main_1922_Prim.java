package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1922 {
	private static int[][] line;
	private static boolean[] visited;
	private static int N;
	private static int totalCost = 0;	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		line = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			if(line[start][end]==0) {
				line[start][end] = val;
				line[end][start] = val;
			}else {
				int newVal = Math.min(line[start][end], val);
				line[start][end] = newVal;
				line[end][start] = newVal;
			}
		}
		
		prim(1); //프림 알고리즘 사용
		System.out.println(totalCost);
	}
	private static void prim(int select) {
		visited[select] = true;
		int nextSelect = -1;
		int nextCost = 200000;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) continue;
			for (int j = 1; j <= N; j++) {
				if(!visited[j] && line[i][j]!=0 && line[i][j]< nextCost) {
					nextSelect = j;
					nextCost = line[i][j];
				}
			}
		}
		if(nextSelect==-1) return;
		totalCost+= nextCost;
		prim(nextSelect);
	}

}
