package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14284 {
	private static int[] valueList;
	private static int[][] graph;
	private static boolean[] visited;
	private static int N;
	private static int M; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N+1][N+1]; // 각 노드간의 거리값 리스트
		valueList = new int[N+1]; // start에서 해당 노드까지의 거리 계산값
		visited = new boolean[N+1]; // 방문 여부
		
		int start,end,val;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			val = Integer.parseInt(st.nextToken());
			
			graph[start][end] = val;
			graph[end][start] = val;
		}
		
		st = new StringTokenizer(br.readLine(), " "); 
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(valueList[end]);
	}
	
	/**다익스트라 알고리즘 : 하나의 정점에서 다른 정점까지의 최단 경로 찾기
	 * 1. 방문x & 가장 거리가 짧은 정점을 찾는다
	 * 2. 해당 정점 방문처리
	 * 3. 2번에서 선택된 정점과 연결된 리스트 업데이트
	 * */
	private static void dijkstra(int start) {
		Arrays.fill(valueList, Integer.MAX_VALUE);
		valueList[start] = 0; // start 정점이 선택되도록 조치
		
		for (int i = 1; i <= N; i++) {
			int temp = Integer.MAX_VALUE;
			int current=0;
			for (int j = 1; j <= N; j++) { // 가장거리가 짧은 정점 찾기
				if(!visited[j] && temp > valueList[j]) {
					current = j;
					temp = valueList[j];
				}
			}
			System.out.println(Arrays.toString(valueList));
			System.out.println(current);
			visited[current] = true; // 해당 정점 방문처리
			
			for (int j = 1; j <= N; j++) { // current 정점과 연결된 새로운 간선 업데이트
				// 방문안한 노트 & 연결된 간선있음 & 현재 값보다 current 정점거쳐서 도착한것이 더 짧다면 업데이트!
				if(!visited[j] && graph[current][j]!=0 && valueList[j] > valueList[current]+graph[current][j]) {
					valueList[j] = valueList[current]+graph[current][j];
				}
			}
		}
	}

}
