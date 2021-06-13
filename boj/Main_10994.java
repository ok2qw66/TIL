package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10994 {

	private static char[][] map;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		N *=4;
		N -= 3;
		map = new char[N][N];
		int len = 5;
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}
		map[N/2][N/2] = '*';
		
		for (int i = N/2-2; i>=0; i-=2,len+=4) {
			makeStar(i,len);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			if(i!=N-1) sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void makeStar(int i, int len) {
		for (int j = 0; j < len; j++) {
			map[i][i+j] = '*';
			map[i+j][i] = '*';
			map[i+j][i+len-1] = '*';
			map[i+len-1][i+j] = '*';
		}
	}

}
