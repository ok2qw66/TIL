package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main_1929 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringJoiner sj = new StringJoiner("\n");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean[] notPrime = new boolean[end+1];
		if(start<= 2)	sj.add("2");
		
		for (int i = 3; i <= end; i+=2) {
			if(!notPrime[i]) {
				if(start <= i) sj.add(String.valueOf(i));
				int temp = 2;
				while(i*temp <= end) {
					notPrime[i*temp++] = true;
				}
			}
		}
		System.out.println(sj.toString());
	}

}
