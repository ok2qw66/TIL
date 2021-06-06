package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922_1 {
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int val;
		public Node(int start, int end, int val) {
			this.start = start;
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
		
	}
	
	private static int N,M;
	private static int[] parents;
	private static Node[] line;
	private static int lineCnt = 0;
	private static int totalCost = 0;
	
	// 크기가 1인 단위집합 만들기
	static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	// parent 찾기
	static int findSet(int a) {
		if(parents[a]==a) return a;
		return parents[a] = findSet(parents[a]);
	}
	// union
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		if(aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		line = new Node[M];
		// 간선리스트 세팅
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			line[i] = new Node(start, end, val);
		}
		// Kruscal 알고리즘 사용
		// 1. 간선 리스트 오름차순 정렬
		Arrays.sort(line);
		// 2. 단위집합 세팅
		make();
		
		for (Node node : line) {
			if(union(node.start, node.end)) {
				totalCost += node.val;
				if(++lineCnt == N-1) break;
			}
		}
		System.out.println(totalCost);
	}


}
