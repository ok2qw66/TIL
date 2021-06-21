package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1967 {
	
	static class Node{
		int next;
		int cost;
		
		public Node(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
		}
	
	}
	
	private static int answerNode = 0;
	private static int maxLength = 0;
	private static boolean[] visited;
	private static ArrayList<Node>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		if(N ==1)
			System.out.println(0);
		else {
			graph = new ArrayList[N+1];
			
			for (int i = 1; i < N+1; i++) {
				graph[i] = new ArrayList<Node>();
			}
			
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph[start].add(new Node(next,cost));
				graph[next].add(new Node(start,cost));
			}
			
			visited = new boolean[N+1];
			start(1,0);
			visited = new boolean[N+1];
			start(answerNode,0);
			System.out.println(maxLength);
		}
	}
	
	private static void start(int current, int length) {
		visited[current] = true;
		if(length > maxLength) {
			maxLength = length;
			answerNode = current;
		}
		
		for (Node n : graph[current]) {
			if(!visited[n.next])
				start(n.next, length+n.cost);
		}
	}

}
