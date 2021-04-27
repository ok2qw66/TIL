package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {
	private static long A,B,C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(goAnswer(B));
	}

	private static long goAnswer(long count) {
		if(count==1) return A % C;
		long temp = goAnswer(count/2);
		if(count%2==0) {
			return temp * temp % C;
		}else {
			return temp * temp %C * A % C;  
		}
		
	}

}
