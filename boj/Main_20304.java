package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20304 {

//	static StringBuilder sb = new StringBuilder();
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
//	static int answer;
//	public static void main(String[] args) throws IOException {
//		int N = Integer.parseInt(br.readLine());//기본 입력
//		int M = Integer.parseInt(br.readLine());
//		Deque<Integer> dq = new ArrayDeque<Integer>();
//		int arr[] = new int[1000001];//최대초기화
//		Arrays.fill(arr, Integer.MIN_VALUE);
//		st = new StringTokenizer(br.readLine());
//		for(int i=1;i<=M;i++) {
//			int x =Integer.parseInt(st.nextToken());
//			arr[x] = 0;
//			dq.offerLast(x);
//		}//M의 범위 1<=M
//		while(!dq.isEmpty()) {
//			int x = dq.pollFirst();
//			for(int i =0;i<20;i++){
//				int nx = x^(1<<i);
//				if(nx>N||arr[nx]!=Integer.MIN_VALUE)continue;
//				arr[nx] = arr[x]+1;
//				dq.offerLast(nx);
//				answer = Math.max(answer, arr[nx]);
//			}
//		}
//		System.out.println(answer);
//	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int[] count = new int[1000001];
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < T; i++) {
			int miss = Integer.parseInt(st.nextToken());
			count[miss] = 1;
			q.add(miss);
		}
		
		while(!q.isEmpty()) {
			int pick = q.poll();
			System.out.println(">>>>>>>>> "+pick+" ("+Integer.toBinaryString(pick)+")");			
			for (int i = 0; 1<<i < N; i++) {
				int next = pick ^ 1<<i;
				System.out.println(next+" ("+Integer.toBinaryString(next)+")");
				if(next<=N && count[next]==0) {
					count[next] = count[pick]+1;
					q.add(next);
					answer = Math.max(answer, count[pick]+1);
				}
			}
		}
		System.out.println(answer-1);
	}

}
