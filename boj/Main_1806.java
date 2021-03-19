package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1806 {

	private static int[] numbers;
	private static int S;
	private static int N;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		answer = N;
		S = Integer.parseInt(st.nextToken());

		numbers = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		int start = 0;
		
		for (int i = 1; i <= N; i++) {
			int val = Integer.parseInt(st.nextToken());
			numbers[i] = numbers[i-1]+val;
			
			if(numbers[i]-numbers[start]>=S) {
				start = getAnswer(start,i);
			}
		}
		
		if(numbers[N] < S) {
			System.out.println(0);
		}else {
			System.out.println(answer);
		}

		
	}

	private static int getAnswer(int start, int end) {
		System.out.println(start+" > "+end);
		for (int i=0; i+start < end; i++) {
			if(numbers[end-i]-numbers[start]>=S) {
				answer = answer>end-start-i? end-start-i:answer;
			}
			
			if(numbers[end]-numbers[start+i]>=S) {
				answer = answer>end-start-i? end-start-i:answer;
			}else {
				return start+i;
			}
		}
		answer = 1;
		return end;
	}

	

}


//10 9
// 1 2 1 2 1 2 1 3 3 2
// 4 10
// 3 4 3 11
// 10 11
//  1 1 1 8 1 2 1 3 3 2
