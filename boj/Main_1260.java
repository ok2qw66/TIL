package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main_1260 {
	public static List<ArrayList> tree;
	public static boolean[] check;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //노드의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색 시작 노드번호
		 
		tree = new LinkedList<ArrayList>();
		check = new boolean[N+1];
		for (int i = 0; i <= N; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			tree.add(temp);
		}
		 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		dfs(V);
		System.out.println();
		check = new boolean[N+1];
		bfs(V);
		 
	}
	
	public static void bfs(int target) {
		StringJoiner sj = new StringJoiner(" ");
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(target);
		check[target] = true;
		
		while(!queue.isEmpty()) {
			int out = queue.poll();
//			System.out.println(out+" "+queue);
			sj.add(String.valueOf(out));
			ArrayList<Integer> test = tree.get(out);
			Collections.sort(test);
			for(int i : test) {
				if(!check[i]) {
					check[i] = true;
					queue.offer(i);					
				}
			}
		}
		System.out.println(sj.toString());
	}
	
	public static void dfs(int target) {
		
		check[target] = true;
		System.out.print(target+" ");
		
		ArrayList<Integer> test = tree.get(target);
		Collections.sort(test);
		for (int x : test) {
			if (!check[x])
				dfs(x);
		}
		
	}

}
