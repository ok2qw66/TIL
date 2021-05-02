package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2846 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] status = {Integer.MAX_VALUE,Integer.MAX_VALUE}; //시작값, 바로직전값
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int current = Integer.parseInt(st.nextToken());
			if(status[1] < current) { //시작값 있음 & 직전값보다 현재값이 크다면
				status[1] = current;
				answer = Math.max(answer, status[1]-status[0]); //업데이트
			}else
				status[0] = status[1] = current;
		}
		
		System.out.println(answer);
	}

}
