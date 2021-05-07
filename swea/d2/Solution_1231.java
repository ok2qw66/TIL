package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1231 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int num = Integer.parseInt(br.readLine()); // 노드의 개수
			String[] tree = new String[num+1];
			boolean[] visited = new boolean[num+1];
			
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int number = Integer.parseInt(st.nextToken());
				tree[number] = st.nextToken();
			}
			System.out.println("#"+testCase+" ");
			//dfs
			dfs(tree, visited, 1);
			System.out.println();
		}

	}

	private static void dfs(String[] tree, boolean[] visited, int target) {
		if(target < 1 || target > tree.length - 1 || visited[target])
			return;
		if(target == tree.length - 1) {
			System.out.print(tree[target]);
			return;
		}
		
		dfs(tree, visited, target*2);
		visited[target] = true;
		System.out.print(tree[target]);
		dfs(tree, visited, target*2+1);
	}

}