package com.ssafy.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5604 {

	private static int mul;
	private static long[] number;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		long start,end;
		
		for (int tc = 1; tc <= TC; tc++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			
			number = new long[10]; //자리수 의미
			int result = 0;
			mul = 1;
			if(start==0) start=1;
			while (start <= end) {
				while(start%10!=0 && start<=end) {//start 끝자리가 0이 될때까지
					cal(start);
					start++;
				}
				if(start>end) break;
				while(end%10!=9 && start<=end) {  //end 끝자리가 9가 될때까지
					cal(end);
					end--;
				}
				long diff = end/10 - start/10 +1;
				for(int i=0;i<10;i++)
					number[i]+=diff*mul;
				mul*=10;
				start/=10;
				end/=10;
			}		
			for (int i = 1; i < 10; i++)
				result += (i * number[i]);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}
	/** 한자리씩 나누어서 더하기*/
	private static void cal(long a) {
		for (long i = a; i > 0; i /= 10) {
			String s = Long.toString(i);
			int t = s.charAt(s.length()-1)-'0';
			number[t]+=mul;				
		}
	}

}
/**참고 : https://imnotabear.tistory.com/59*/
