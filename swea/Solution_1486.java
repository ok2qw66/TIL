package com.ssafy.subclass.preview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1486 {
	
	private static int answer = Integer.MAX_VALUE;
	private static Integer[] heights;
	private static int S;
	private static boolean isEnd;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			isEnd = false;
			answer = Integer.MAX_VALUE;
			int N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			heights = new Integer[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(heights, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			
			int start = 0;
			for (int i = 0; i < heights.length; i++) {
				if(heights[i] <= S) {
					start = i;
					break;
				}
			}
			
			findMininum(start,0);
			sb.append("#").append(testCase).append(" ").append(answer-S).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void findMininum(int idx, int sum) {
		if(sum > S) {
			answer = Math.min(sum, answer);
			return;
		}else if(sum == S) {
			answer = sum;
			isEnd = true;
			return;
		}
		if(idx >= heights.length)	return;
		
		for (int i = idx; i < heights.length && !isEnd; i++) {
			findMininum(i+1, sum+heights[i]);
			findMininum(i+1, sum);
		}
		
	}

}
