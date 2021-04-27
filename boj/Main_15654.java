package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main_15654 {
	private static int N,M;
	private static int[] check;
	private static boolean[] visited;
	private static StringJoiner sb = new StringJoiner("\n");
	private static int[] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		visited = new boolean[N];
		check = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		goCombi(0);
		System.out.println(sb.toString());
		
	}
	
	private static void goCombi(int count) {
		if(count==M) {
			updateAnswer();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				check[count] = numbers[i];
				goCombi(count+1);
				visited[i] = false;
			}
				
		}
	}

	private static void updateAnswer() {
		StringJoiner sj = new StringJoiner(" ");
		for (int i : check) {
			sj.add(String.valueOf(i));
		}
		sb.add(sj.toString());
	}

}
