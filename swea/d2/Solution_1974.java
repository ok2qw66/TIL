package com.ssafy.swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		int[] sample = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		for (int test_case=1;test_case<=T;test_case++) {
			int[][] puzzle = new int[9][9];
			int answer = 1;
			
			for ( int i=0;i<puzzle.length;i++)
				for( int j=0;j<puzzle[i].length;j++)
					puzzle[i][j] = sc.nextInt();
				
			// 가로 행 확인
			for ( int i=0;i<puzzle.length;i++) {
				int[] test_horizontal = puzzle[i].clone();
				Arrays.sort(test_horizontal);
				if (!Arrays.equals(sample, test_horizontal)) {
					answer = 0;
					break;					
				}
			}
			// 세로 열 확인
			if(answer == 1) {
				for( int i=0;i<puzzle.length;i++) {
					int[] test_vertical = new int[9];
					for( int j=0;j<puzzle[i].length;j++)
						test_vertical[j] = puzzle[j][i];
					Arrays.sort(test_vertical);
					if (!Arrays.equals(sample, test_vertical)) {
						answer = 0;
						break;
					}
				}
			}
			// 3x3 정사각형 확인
			if(answer == 1) {
				for( int i=0;i<9;) {
					int[] test_square = new int[9];
					int idx = 0;
					for(;idx<9;i++) {
						int j = 0;
						test_square[idx++] = puzzle[i][j++];
						test_square[idx++] = puzzle[i][j++];
						test_square[idx++] = puzzle[i][j++];
					}
					Arrays.sort(test_square);
					if (!Arrays.equals(sample, test_square)) {
						answer= 0;
						break;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}
	}
}
