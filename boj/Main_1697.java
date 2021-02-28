package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
	private static boolean[] visited = new boolean[100001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N, M));
	}

	private static int bfs(int current, int target) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {current,0});
		visited[current] = true;
		
		while(!queue.isEmpty()) {
			int[] pick = queue.poll();
			
			if(pick[0]== target) {
				return pick[1];
			}
			
			if(pick[0]-1 >=0 && !visited[pick[0]-1]) {
				visited[pick[0]-1] = true;
				queue.add(new int[] {pick[0]-1,pick[1]+1});
			}
			if(pick[0]+1 < visited.length && !visited[pick[0]+1]){
				visited[pick[0]+1] = true;
				queue.add(new int[] {pick[0]+1,pick[1]+1});
			}
			if(pick[0]*2 <= visited.length && !visited[pick[0]*2]){
				visited[pick[0]*2] = true;
				queue.add(new int[] {pick[0]*2,pick[1]+1});
			}
		}
		
		return 0;
		
	}

}
