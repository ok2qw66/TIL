package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1946 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			// 이렇게하면 입력과 동시에 정렬됨
			int num[] = new int[N+1]; // 계수배열
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				num[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}	
			
			int answer = N;
			int min = N+1;
			for(int i=1;i<N+1;i++) {
				if(min < num[i]) 
					answer--;
				else
					min = num[i];
			}
			
			
			sb.append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
