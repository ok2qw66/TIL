package com.ssafy.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2458 {

	private static int[][] graph;
	private static int N,M;
	private static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        graph = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) { 
            for (int j = 1; j <= N; j++) { 
                Arrays.fill(graph[i], Integer.MAX_VALUE);
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
        }

        floydWarshall();
        findAnswer();
        System.out.println(answer);
    }
		
	private static void findAnswer() {
		for (int current = 1; current <= N; current++) {
			boolean check = true;
			for (int compare = 1; compare <= N; compare++) {
				if(current==compare) continue;
				if(graph[current][compare]==Integer.MAX_VALUE && graph[compare][current]==Integer.MAX_VALUE) {
					check = false;
					break;
				}
			}
			if(check)    answer++;
		}
		
	}

	private static void floydWarshall() {
		for (int hover = 1; hover <= N; hover++) { //경유지
			for (int start = 1; start <= N; start++) { //출발지
				for (int stop = 1; stop <= N; stop++) { //도착지
					if(start==stop) continue;
					if(graph[start][hover]!=Integer.MAX_VALUE && graph[hover][stop]!=Integer.MAX_VALUE && graph[start][stop] > graph[start][hover]+graph[hover][stop])
						graph[start][stop] = graph[start][hover]+graph[hover][stop];
				}
			}
		}
		
	}

}

