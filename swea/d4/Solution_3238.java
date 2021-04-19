package com.ssafy.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238 {

	static long nCr(long n, long r, long p) {
		if(r==0)
			return 1L;
		
		long[][] fac = new long[(int) (n/r)][(int)r];
		fac[0][0] = 1;
		
		for (int i = 1; i <= n; i++) {
			fac[(int) (i/r)][(int) (i%r)] = fac[(int) ((i-1)/r)][(int) ((i-1)%r)]* i % p;
		}
		
		return (fac[(int) (n/r)][(int) (n%r)] * power(fac[(int) ((n-r)/r)][(int) ((n-r)%r)],p-2,p)%p) %p;
	}
	
	private static long power(long x, long l, long p) {
		long res = 1L;
		x = x %p;
		while(l >0) {
			if(l%2 == 1)
				res = (res*x) %p;
			l >>= 1;
			x = (x*x)%p;
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			long P = Long.parseLong(st.nextToken());
			
			sb.append("#").append(tc).append(" ").append(nCr(N, R, P)).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
