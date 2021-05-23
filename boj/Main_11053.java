package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i-1; j >= 0; j--) {
				if(array[j][0] < array[i][0]) {
					array[i][1] = Math.max(array[i][1], array[j][1]+1);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, array[i][1]);
		}
		System.out.println(max);
	}

}
