package com.ssafy.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jungol_1205 {
	private static int count=0;
	private static int[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		check = new int[T];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < T; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(check);
		System.out.println(Arrays.toString(check));
		int joker = 0;
		
		for (int i = 0; i < check.length; i++) {
			if(check[i]==0) {
				joker++;
				count++;
			}else {
				verify(joker,i);
			}
		}
	
		System.out.println(count);
	}
	
	
	private static void verify(int joker, int i) {
		int prev=check[i];
		int tempCnt = 1;
		
		for (int j = i; j < check.length; j++) {
			if(prev==check[j]) {
				continue;
			}else if(check[j]-prev-1 <= joker) {
				joker -= check[j]-prev-1;
				tempCnt += check[j]-prev;
				prev = check[j];
			}else {
				break;
			}
		}
		count = tempCnt+joker> count? tempCnt+joker : count;
		return;
		
	}

}
