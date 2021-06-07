package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1068 {
	private static int delete;
	private static int leafCnt = 0;
	private static boolean[] isCheck;
	private static ArrayList<Integer>[] connect;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		isCheck = new boolean[N];
		connect = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			connect[i] = new ArrayList<Integer>();
		}
		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent==-1) root = i;
			else connect[parent].add(i);
		}
		delete = Integer.parseInt(br.readLine());
		
		findLeafNode(root);
		System.out.println(leafCnt);
	}
	
	private static void findLeafNode(int current) {
		if(current == delete) return;
		isCheck[current] = true;
		if(connect[current].size()==0 || (connect[current].size()==1 && connect[current].get(0)==delete)) {
			leafCnt++;
			return;
		}
		for (Integer next : connect[current]) {
			findLeafNode(next);
		}
	}

}
