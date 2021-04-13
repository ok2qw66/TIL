package com.btype.adhoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3814 {

	private static int[] array;
	private static int N;
	private static int K;
	private static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int max = 0;
			answer=Integer.MAX_VALUE;
			array = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			array[0] = Integer.parseInt(st.nextToken());
			for (int i = 1; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, Math.abs(array[i]-array[i-1]));
			}
			binarySearch(0,max);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void binarySearch(int start, int end) {
		if(start==end) return;
		
		int mid = (start+end)/2;
		int cnt = 0;
		
		int[] clone = array.clone();
		
		for (int i = 1; i < N; i++) {
			int differ = Math.abs(clone[i]-clone[i-1]);
			if(differ > mid) {
				cnt += differ-mid;
				if(clone[i]>clone[i-1])
					clone[i] -= differ-mid;
				else
					clone[i-1] -= differ-mid;
			}
		}
		
		for (int i = N-1; i >=1; i--) {
			int differ = Math.abs(clone[i]-clone[i-1]);
			if(differ > mid) {
				cnt += differ-mid;
				if(clone[i]>clone[i-1])
					clone[i] -= differ-mid;
				else
					clone[i-1] -= differ-mid;
			}
			
		}
		
		if(cnt>K) {
			binarySearch(mid+1, end);
		}else if(cnt<K) {
			answer = mid;
			binarySearch(start, mid);
		}else {
			answer = mid;
		}
	}

}
