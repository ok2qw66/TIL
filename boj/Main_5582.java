package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5582 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		int[][] dp = new int[str1.length+1][str2.length+1];
		
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if(str1[i-1]==str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] +1;
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		
		System.out.println(answer);
	}

}
