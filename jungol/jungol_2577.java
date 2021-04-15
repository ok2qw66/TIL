package com.ssafy.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥고_안예진 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //접시의 수
		int D = Integer.parseInt(st.nextToken()); // 초밥종류
		int K = Integer.parseInt(st.nextToken()); // 연속 접시 수
		int C = Integer.parseInt(st.nextToken()); // 쿠폰번호
		int answer = 0;
		boolean CouponAffect = true;
		HashMap<Integer,Integer> sushi = new HashMap<Integer,Integer>();
		int[] rotateTable = new int[N];
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			rotateTable[i] = number;
			if(number==C) CouponAffect = false;
			if(sushi.get(number)==null)
				sushi.put(number, 0);
		}
		int start=0,end=0;
		for (; end <= N;) {
			int max = sushi.get(C)==1 ? K+1 : K;
			System.out.println(start+" "+end);
			if(end==N || end-start+1 >= max) {
				answer = Math.max(answer, end-start+1);
				break;
			}
			if(sushi.get(rotateTable[end])==0) { //겹치는게 없다
				sushi.put(rotateTable[end], 1);
				end++;
			}else {
				answer = Math.max(answer, end-start+1);
				System.out.println("answer update "+answer);
				while(sushi.get(rotateTable[end])!=0) {
					sushi.put(rotateTable[start++], 0);
				}
			}
		}
		
		
		System.out.println(CouponAffect? answer+1 : answer);
	}

}
