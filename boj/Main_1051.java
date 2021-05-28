package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051 {

	private static int[][] rectangle;
	private static int N,M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		rectangle = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				rectangle[i][j] = line.charAt(j) - '0';
			}
		}
		
		System.out.println(findSquare(Math.min(N, M)));
	}

	private static int findSquare(int min) {
		int target = 0;
		if(min==0) return 1;
		for (int i = 0; i < N - min; i++) {
			for (int j = 0; j < M-min; j++) {
				if(rectangle[i][j]==rectangle[i][j+min]) {
					target = rectangle[i][j];
					if(target == rectangle[i+min][j] && target == rectangle[i+min][j+min]) {
						return (int) Math.pow(min+1,2);
					}
				}
				
			}
		}
		return findSquare(min-1);
	}

}
