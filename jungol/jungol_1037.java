package com.ssafy.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1037 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[N][N];
		int x = -1,y=-1;
		boolean isContinue = true;
		for (int i = 0; i < N && isContinue; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int temp = 0;
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				temp += matrix[i][j];
			}
			if(temp%2==1) {
				if(x==-1) {
					x = i;
				}else {
					System.out.println("Corrupt");
					isContinue = false;
					break;
				}
			}
		}
		
		for (int i = 0; i < N && isContinue; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				temp += matrix[j][i];
			}
			if(temp%2==1) {
				if(y==-1) {
					y = i;
				}else {
					System.out.println("Corrupt");
					isContinue = false;
					break;
				}
			}
		}
		
		if(isContinue) {
			if(x==-1 && y == -1) {
				System.out.println("OK");
			}else {
				System.out.println("Change bit ("+(x+1)+","+(y+1)+")");
			}
		}
		
	}

}
