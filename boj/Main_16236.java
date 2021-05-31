package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16236 {
	private static int N;
	private static int time = 0;
	private static int[][] space;
	private static int[] babyshark = new int[4];
	private static int[] fish = new int[6];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		space = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j]==9) {
					babyshark = new int[]{i,j,2,0};
				}else {
					fish[space[i][j]]++;				
				}
			}
		}
		
		while(isPossible()) {
			if(!eatPrey()) {
				break;
			}
			time++;
			checkSharkStatus();
		}
		System.out.println(time);
	}
	
	private static void checkSharkStatus() {
		
	}

	private static boolean eatPrey() {
		return true;
	}
	
	private static boolean isPossible() {
		int prey = 0;
		for (int i = 0; i < babyshark[2]; i++) {
			prey += fish[i];
		}
		
		if(prey>0)
			return true;
		return false;
	}

}
