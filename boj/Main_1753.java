package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753 {

	static class EndWeight {
		int end;
		int weight;
		
		public EndWeight(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	
	private static ArrayList<EndWeight>[] graph;
	private static int[] answer;
	private static int V;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken()); //정점 갯수
		int E = Integer.parseInt(st.nextToken()); //간선 갯수
		int startNode = Integer.parseInt(br.readLine()); //시작 정점
		graph = new ArrayList[V+1];
		answer = new int[V+1];
		Arrays.fill(answer, 500000);
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<EndWeight>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start].add(new EndWeight(end,weight));
		}
		
		djikstra(startNode);
		
		for (int i = 1; i <= V; i++) {
			sb.append(answer[i]==500000? "INF" : answer[i]);
			if(i!=V)	sb.append("\n");
			
		}
		System.out.println(sb);
	}

	private static void djikstra(int startNode) {
		answer[startNode] = 0;
		boolean[] visited = new boolean[V+1];
		
		for (int i = 0; i < V; i++) {
			int current = 0;
			int min = 500000;
			for (int idx = 1; idx <= V; idx++) { //가장 가까운 점 찾기
				if(!visited[idx] && min > answer[idx]) {
					current = idx;
					min = answer[idx];
				}
			}
			
			if(current==0) return;
			
			visited[current] = true; //가장 가까운 점 방문
			//System.out.println(current);
			for (EndWeight temp : graph[current]) { //현재방문한 점 거쳐서 최단경로 있는지 확인
				if(!visited[temp.end] && answer[temp.end] > answer[current]+temp.weight) {
					answer[temp.end] = answer[current]+temp.weight;
				}
			}		
			
		}
	}

}
