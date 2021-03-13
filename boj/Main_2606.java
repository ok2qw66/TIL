package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606 {

	private static ArrayList<Integer>[] nodeList;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int NodeNum = Integer.parseInt(br.readLine());
		nodeList = new ArrayList[N+1];
		visited = new boolean[N+1];
		int start,end;
		
		for (int i = 0; i < NodeNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			if(nodeList[start] == null) {
				nodeList[start] = new ArrayList<Integer>();
			}
			
			if(nodeList[end] == null) {
				nodeList[end] = new ArrayList<Integer>();
			}
		
			nodeList[start].add(end);
			nodeList[end].add(start);
		}
		visited[1] = true;
		System.out.println(spread(1,0));
		
	}

	private static int spread(int number, int cnt) {
		int test;
		for (int i = 0; i < nodeList[number].size(); i++) {
			test = nodeList[number].get(i);
			if(!visited[test]) {
				//System.out.println("visit : "+number+" >"+test);
				visited[test] = true;
				cnt = spread(test,cnt+1);
			}
		}
		return cnt;
	}

}
