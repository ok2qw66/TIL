package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N+1];
			
			for (int r = 0; r < 2; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int c = 1; c <= N; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int c = 2; c <= N; c++) {
				sticker[0][c] += Math.max(Math.max(sticker[1][c-1], sticker[0][c-2]), sticker[1][c-2]);
				sticker[1][c] += Math.max(Math.max(sticker[0][c-1], sticker[0][c-2]), sticker[1][c-2]);
			}
			
			sb.append(Math.max(sticker[0][N], sticker[1][N])).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}

}
