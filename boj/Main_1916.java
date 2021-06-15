package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1916 {

	private static int[][] graph;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		graph = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			graph[start][end] = Integer.min(cost, graph[start][end]);
		}
		
		calculMinCost();
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		System.out.println(graph[start][end]);
	}

	private static void calculMinCost() {
		for (int hover = 0; hover < N; hover++) {
			for (int start = 0; start < N; start++) {
				for (int end = 0; end < N; end++) {
					if(hover==end) continue;
					if(graph[start][hover]!=Integer.MAX_VALUE && graph[hover][end]!=Integer.MAX_VALUE && graph[start][end] > graph[start][hover]+graph[hover][end]) {
						graph[start][end] = graph[start][hover]+graph[hover][end];
					}
				}
			}
		}
		
	}

}
