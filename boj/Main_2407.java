package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		BigInteger c[][] = new BigInteger[1001][1001];
		
		
		for (int n = 1; n <= N; n++) {
			for (int m = 0; m <=n; m++) {
				if(m==0 || n==m)
					c[n][m] = new BigInteger("1");
				else
					c[n][m] = c[n-1][m].add(c[n-1][m-1]);
			}
		}
		
		System.out.println(c[N][M]);
	}

}
