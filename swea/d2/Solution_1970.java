package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Solution_1970 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		int[] dollars = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int cnt = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= cnt; i++) {
			StringJoiner sj = new StringJoiner(" ");
			int money = Integer.parseInt(br.readLine());
			
			for(int dollar: dollars) {
				if(money >= dollar) {
					int temp = money/dollar;
					sj.add(String.valueOf(temp));
					money -= temp*dollar; 
				}else {
					sj.add("0");
				}
			}
			System.out.println("#"+i);
			System.out.println(sj.toString());
		
		}
	}

}
