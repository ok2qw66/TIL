package com.ssafy.subclass.preview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1219 {

	private static int[][] nodeEdge;
	private static boolean[] visited;
	private static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String line;
		int cnt = 0;
		while(cnt++<10) {
			line=br.readLine();
			nodeEdge = new int[100][2];
			visited = new boolean[100];
			answer = 0;
			st = new StringTokenizer(line," ");
			int testCase = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < size; i++) {
				int start = Integer.parseInt(st.nextToken());
				int target = Integer.parseInt(st.nextToken());
				//System.out.println(start+ " " +target);
				if(nodeEdge[start][0] !=0) {
					nodeEdge[start][1] = target;
				}else {
					nodeEdge[start][0] = target;
				}
			}
			
			dfs(0);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	private static void dfs(int idx) {
		if(visited[idx])	return;
		
		visited[idx] = true;
		
		int[] next = nodeEdge[idx];
		//System.out.println(idx+"th : "+ Arrays.toString(next));
		for (int i = 0; i < next.length && answer==0; i++) {
			if(next[i]==99) {
				answer = 1;
				return;
			}
			else if(next[i] != 0){
				dfs(next[i]);
			}
		}
		
	}

}
