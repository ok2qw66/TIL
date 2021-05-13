package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18429 {

	private static int N,K;
	private static int[] weights;
	private static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N��
		K = Integer.parseInt(st.nextToken()); // K��ŭ ����
		weights = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		findCases(0,0,0);
		System.out.println(answer);
	}
	
	private static void findCases(int cnt, int flag, int current) {
		if(cnt==N) {
			answer++;
			return;
		}
		
		current -= K; //K��ŭ �߷� ����
		for (int i = 0; i < N; i++) {
			if((1<<i & flag) ==0 && current+weights[i]>=0) {
				findCases(cnt+1,(flag| 1<<i),current+weights[i]);
			}
		}
		
	}

}
