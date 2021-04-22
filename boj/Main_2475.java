package com.ssafy.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int answer = 0;
		for (int i = 0; i < 5; i++) {
			int number = Integer.parseInt(st.nextToken());
			answer += (number*number)%10;
		}
		System.out.println(answer%10);
	}

}
