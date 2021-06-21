package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1167 {
	private static int answer = 0;
	private static ArrayList<int[]>[] tree;
	private static int N;
	private static boolean[] visited;
	private static int maxLength;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			tree[i] = new ArrayList<int[]>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int vertex = Integer.parseInt(st.nextToken());
			int next;
			while((next = Integer.parseInt(st.nextToken()))!=-1) {
				tree[vertex].add(new int[]{next, Integer.parseInt(st.nextToken())});
			}
			
		}
		//임의의 점에서 시작
		visited = new boolean[N+1];
		start(1, 0);
		// 가장 먼 점에서 시작
		visited = new boolean[N+1];
		start(maxLength, 0);
		System.out.println(answer);
	}
	
	private static void start(int i, int length) {
		visited[i] = true;
		if(answer < length) {
			answer = length;
			maxLength = i;
		}
		
		for (int[] v : tree[i]) {
			if(!visited[v[0]]) {
				start(v[0], length + v[1]);
			}
		}
		
	}

}
